package com.rest.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rest.entities.Assessment;
@Repository
public interface AssessmentRepository extends JpaRepository<Assessment,Integer>{
	@Query("from Assessment a where a.assessmentName =:assessmentname")
	List<Assessment> getByName(@Param("assessmentname") String assessmentName);
}
