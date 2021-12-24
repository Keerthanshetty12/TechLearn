package com.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rest.entities.Assessment;
import com.rest.entities.User;
import com.rest.entities.UserAssessment;

@Repository
public interface UserAssessmentRepository extends JpaRepository<UserAssessment, Integer> {
	
	@Query("select ua.assessment from UserAssessment ua where ua.user.userName =:userName")
	List<Assessment> getAssessmentsTakenByUser(@Param("userName") String userName);
}
