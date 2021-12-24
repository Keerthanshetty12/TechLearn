package com.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rest.entities.Activity;
import com.rest.entities.UserActivity;
@Repository
public interface UserActivityRepository extends JpaRepository<UserActivity, Integer>{
	@Query("select ua.activity from UserActivity ua where ua.user.userName=:uname")
	List<Activity> getActivityTakenByUser(@Param("uname") String userName);
	
}
//@Query("select ua.activity.activityName from UserActivity ua where ua.user.userId=:uid")
//List<String> getActivityTakenByUser(@Param("uid") Integer userId);