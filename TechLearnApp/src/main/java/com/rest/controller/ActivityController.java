package com.rest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.rest.entities.Assessment;
import com.rest.entities.Response;
import com.rest.entities.User;
import com.rest.enums.Role;
import com.rest.exceptions.NotAuthorizedException;
import com.rest.jwt.JwtTokenUtil;
import com.rest.service.ActivityService;

@RestController
@RequestMapping("activity")
@CrossOrigin(origins = "http://localhost:4200")
public class ActivityController {
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	ActivityService service;

	User user;
	
	@GetMapping
	public List<Activity> getAll() {
		return service.getAllActivity();
	}

	@PostMapping
	public ResponseEntity<Response> saveActivity(@RequestBody Activity a,HttpServletRequest request) {
		user = jwtTokenUtil.validateTokenAndGetUserDetails(request);
		
		Role role=user.getRole();
		if(!(role==Role.ADMIN)) {
		throw new NotAuthorizedException("Only Admin can create Activity.");
		}
		service.save(a);
		return new ResponseEntity<Response>(new Response("Activity with ID " + a.getActivityId()+ " successfully saved"),HttpStatus.CREATED);
	

	}

	@GetMapping("{activityid}")
	public ResponseEntity<?> getActivity(@PathVariable("activityid") Integer activityId) {
		Activity a = service.getActivity(activityId);
		return new ResponseEntity<Activity>(a, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<?> updateActivity(@RequestBody Activity a) {
			service.update(a);
		return new ResponseEntity<Response>(new Response("Activity with ID " + a.getActivityId() + " successfully updated"),HttpStatus.OK);
	}

	@DeleteMapping("{activityid}")
	public ResponseEntity<?> deleteActivity(@PathVariable("activityid") Integer aid) {
	service.delete(aid);
		return new ResponseEntity<Response>(new Response("Activity with ID " + aid + " successfully deleted"), HttpStatus.OK);
	}

}