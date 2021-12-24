package com.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.dao.UserActivityDao;
import com.rest.entities.Activity;
import com.rest.entities.UserActivity;

@Service
public class UserActivityServiceImplementation implements UserActivityService {
	@Autowired
	UserActivityDao userActivityDao;

	@Override
	public UserActivity getUserActivity(Integer userActivityId) {
		// TODO Auto-generated method stub
		return userActivityDao.getUserActivity(userActivityId);
	}

	@Override
	public List<UserActivity> getAllUserActivity() {
		// TODO Auto-generated method stub
		return userActivityDao.getAllUserActivity();
	}

	@Override
	public List<Activity> getActivityTakenByUser(String userName) {
		// TODO Auto-generated method stub
		return userActivityDao.getActivityTakenByUser(userName);
	}

	@Override
	public void save(UserActivity userActivity) {
		// TODO Auto-generated method stub
		userActivityDao.saveUserActivity(userActivity);
	}
}
