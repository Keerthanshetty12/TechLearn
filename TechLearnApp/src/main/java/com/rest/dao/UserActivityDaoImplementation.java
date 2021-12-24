package com.rest.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.entities.Activity;
import com.rest.entities.UserActivity;
import com.rest.exceptions.ActivityNotFoundException;
import com.rest.exceptions.NoDataException;

import com.rest.repository.UserActivityRepository;

@Service
public class UserActivityDaoImplementation implements UserActivityDao {

	@Autowired
	UserActivityRepository userActivityRepository;

	@Override
	public UserActivity getUserActivity(Integer userActivityId) throws ActivityNotFoundException {

		Optional<UserActivity> res = userActivityRepository.findById(userActivityId);
		if (res.isPresent()) {
			UserActivity r = res.get();
			return r;
		} else {
			throw new ActivityNotFoundException("User with ID " +userActivityId + " not found for this activity");
		}
	}

	@Override
	public void saveUserActivity(UserActivity ua) throws ActivityNotFoundException {
		if (userActivityRepository.existsById(ua.getUserAvtivityId()))
			throw new ActivityNotFoundException("User with ID " + ua.getUserAvtivityId() + " already exists");
		userActivityRepository.save(ua);

	}

	@Override
	public List<UserActivity> getAllUserActivity() throws ActivityNotFoundException {
		List<UserActivity> list = userActivityRepository.findAll();
		if (list.size() == 0)
			throw new NoDataException("No UserActivity exists in the database");
		return list;
	}

	@Override
	public List<Activity> getActivityTakenByUser(String UserName) {
		return userActivityRepository.getActivityTakenByUser(UserName);
	}

}
