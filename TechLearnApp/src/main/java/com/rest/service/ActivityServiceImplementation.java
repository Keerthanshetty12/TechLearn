package com.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.dao.ActivityDao;
import com.rest.entities.Activity;

@Service
public class ActivityServiceImplementation implements ActivityService {

	@Autowired
	ActivityDao dao;

	@Override
	public Activity getActivity(Integer activityId) {
		// TODO Auto-generated method stub
		return dao.getActivity(activityId);
	}
	
	@Override
	public List<Activity> getAllActivity() {
		return dao.getAllActivity();
	}

	@Override
	public void save(Activity a) {
		dao.saveActivity(a);
	}

	@Override
	public void update(Activity a) {
		dao.updateActivity(a);
	}

	@Override
	public void delete(Integer aid) {
		dao.deleteActivity(aid);

	}

	@Override
	public List<Activity> getByName(String activityName) {
		return dao.getByName(activityName);
	}

	

}