package com.rest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rest.entities.Activity;
import com.rest.entities.UserActivity;
import com.rest.entities.UserAssessment;

@Service
public interface UserActivityService {
	
	UserActivity getUserActivity(Integer userActivityId);

	List<UserActivity> getAllUserActivity();
	
	List<Activity> getActivityTakenByUser(String userName);
	
	void save(UserActivity userActivity );
}
