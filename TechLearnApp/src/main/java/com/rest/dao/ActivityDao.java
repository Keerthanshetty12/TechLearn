package com.rest.dao;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rest.entities.Activity;
import com.rest.exceptions.ActivityNotFoundException;
import com.rest.exceptions.DuplicateEntityException;
import com.rest.exceptions.NoDataException;


@Service
public interface ActivityDao {

	Activity getActivity(int activityId) throws ActivityNotFoundException;
	
	List<Activity> getAllActivity() throws NoDataException;
	
	void updateActivity(Activity a) throws ActivityNotFoundException;
	
	void saveActivity(Activity a) throws DuplicateEntityException;
	
	void deleteActivity(int activityId) throws ActivityNotFoundException;

	List<Activity> getByName(String activityName);

}
