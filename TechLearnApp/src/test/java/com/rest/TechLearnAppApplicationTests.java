package com.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rest.entities.User;
import com.rest.service.UserService;

@SpringBootTest
class TechLearnAppApplicationTests {
	
	@Autowired
	UserService userService;
	/*
	@Autowired
	ActivityRepository activityRepo;
	@Autowired
	AssessmentRepository assessmentRepo;
	@Autowired
	UserActivityRepository userActivityRepo;
	@Autowired
	UserAssessmentRepository userAssessmentRepo;
	*/
	@Test
	public void getUserTest()
	{
	User u = userService.getUser("Ramanakv");
	assertEquals(u.getUserName(),"Ramanakv");
	}
	
	@Test
	void contextLoads() {
	}

}
