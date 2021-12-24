package com.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rest.entities.Activity;
import com.rest.entities.User;

@Repository
public interface ActivityRepository extends JpaRepository<Activity,Integer>{
	
	@Query("from Activity a where a.activityName=:activityname")
	List<Activity> getByName(@Param("activityname")String activityName);
}
