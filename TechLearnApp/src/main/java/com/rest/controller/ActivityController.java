package com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.entities.Activity;
import com.rest.entities.User;
import com.rest.service.ActivityService;

@RestController
@RequestMapping("activity")
@CrossOrigin(origins = "http://localhost:4200")
public class ActivityController {

	// @Autowired
	// private JwtUtil jwtTokenUtil;

	@Autowired
	ActivityService service;


	@GetMapping
	public List<Activity> getAll() {
		return service.getAllActivity();
	}

	@PostMapping
	public ResponseEntity<String> saveActivity(@RequestBody Activity a) {
/*
		Role role = user.getRole();
		if (!(role.equals("admin")))
			throw new NotAuthorizedException("Save Activity Data can only be done by Admin.");
	*/
		service.save(a);
		return new ResponseEntity<String>("Activity with ID " + a.getActivityId() + " successfully saved",
				HttpStatus.CREATED);

	}

	@PutMapping
	public ResponseEntity<String> updateActivity(@RequestBody Activity a) {
		/*Role role = user.getRole();
		if (!(role.equals("admin")))
			throw new NotAuthorizedException("Save Activity Data can only be done by Admin.");
		*/
		service.update(a);
		return new ResponseEntity<String>("Activity with ID " + a.getActivityId() + " successfully updated",
				HttpStatus.OK);
	}

	@DeleteMapping("{activityid}")
	public ResponseEntity<String> deleteActivity(@PathVariable("activityid") Integer aid) {
	/*	Role role = user.getRole();
		if (!(role.equals("admin")))
			throw new NotAuthorizedException("Save Activity Data can only be done by Admin.");
	*/
		service.delete(aid);
		return new ResponseEntity<String>("Activity with ID " + aid + " successfully deleted", HttpStatus.OK);
	}

}