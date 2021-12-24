package com.rest.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rest.entities.Activity;
import com.rest.entities.UserActivity;
import com.rest.exceptions.ActivityNotFoundException;

@Service
public interface UserActivityDao {
	
	UserActivity getUserActivity(Integer userActivityId) throws ActivityNotFoundException;

	void saveUserActivity(UserActivity ua) throws ActivityNotFoundException;

	List<UserActivity> getAllUserActivity() throws ActivityNotFoundException;

	List<Activity> getActivityTakenByUser(String UserName);

}
