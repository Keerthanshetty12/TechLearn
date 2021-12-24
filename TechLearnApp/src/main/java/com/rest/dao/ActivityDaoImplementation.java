package com.rest.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.entities.Activity;
import com.rest.exceptions.ActivityNotFoundException;
import com.rest.exceptions.DuplicateEntityException;
import com.rest.exceptions.NoDataException;
import com.rest.repository.ActivityRepository;


@Service
public class ActivityDaoImplementation implements ActivityDao {

	@Autowired
	ActivityRepository repository;
	
	@Override
	public Activity getActivity(int activityId) throws ActivityNotFoundException {
		 
	   Optional<Activity> opt = repository.findById(activityId);
	   if(opt.isPresent()) {
		   Activity a=opt.get();
		   return a;
	   }
	   else {
		  throw new ActivityNotFoundException("Activity with ID "+activityId+" not found");
		  }
		}

	@Override
	public List<Activity> getAllActivity() throws NoDataException {
		List<Activity> list=repository.findAll();
		if(list.size()==0)
			throw new NoDataException("No Activity exists in the database");
		return list;
	}

	@Override
	public void updateActivity(Activity a) throws ActivityNotFoundException {
		if(!(repository.existsById(a.getActivityId())))
			throw new ActivityNotFoundException("Activity with ID "+a.getActivityId()+" not found to update");
		repository.save(a);
	}

	@Override
	public void saveActivity(Activity a) throws DuplicateEntityException {
		if(repository.existsById(a.getActivityId()))
			throw new DuplicateEntityException("Activity with ID "+a.getActivityId()+" already exists");
		repository.save(a);
	}

	@Override
	public void deleteActivity(int activityId) throws ActivityNotFoundException {
		if(!(repository.existsById(activityId)))
			throw new ActivityNotFoundException("Activity with ID "+activityId+" not found to delete");
		repository.deleteById(activityId);
	}

	@Override
	public List<Activity> getByName(String activityName) {
		return repository.getByName(activityName);
	}
	

	
	
	
}
