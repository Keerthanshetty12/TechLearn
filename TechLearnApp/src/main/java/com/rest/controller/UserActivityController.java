package com.rest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.entities.Activity;
import com.rest.entities.User;
import com.rest.entities.UserActivity;
import com.rest.enums.Role;
import com.rest.exceptions.NotAuthorizedException;
import com.rest.service.UserActivityService;

@RestController
@RequestMapping("useractivity")
public class UserActivityController {

	@Autowired
	UserActivityService userActivityService;

	
	Logger logger = LoggerFactory.getLogger(UserActivityController.class);

	@GetMapping("{useractivityid}")
	public UserActivity getUserActivity(@PathVariable("useractivityid") Integer userActivityId) {

		UserActivity r = userActivityService.getUserActivity(userActivityId);
		return r;
	}

	@GetMapping("{username}")
	public List<Activity> getAllActivity(@PathVariable("username") String userName) {
		List<Activity> r = userActivityService.getActivityTakenByUser(userName);
		return r;
	}

	@GetMapping
	public List<UserActivity> getAll() {
		logger.info("Activity of all users");
		return userActivityService.getAllUserActivity();
	}

	@PostMapping
	public ResponseEntity<String> saveUserActivity(@RequestBody UserActivity a) {
		/*Role role = user.getRole();
		if (!(role.equals("admin")))
			throw new NotAuthorizedException("create Activity for user can only be done by Admin.");
*/
		userActivityService.save(a);
		logger.info(" user saved");
		return new ResponseEntity<String>("Result with userId" + a.getUser() + " successfully saved",
				HttpStatus.CREATED);
	}

}
