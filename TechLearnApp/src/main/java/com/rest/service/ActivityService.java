package com.rest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rest.entities.Activity;

@Service
public interface ActivityService {
	Activity getActivity(Integer activityId);
	
	List<Activity> getAllActivity();

	void save(Activity a);

	void update(Activity a);

	void delete(Integer aid);

	List<Activity> getByName(String activityName);
}