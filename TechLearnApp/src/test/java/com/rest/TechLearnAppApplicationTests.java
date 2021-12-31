package com.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;
import java.util.List;

import org.assertj.core.api.Fail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rest.entities.Activity;
import com.rest.entities.Assessment;
import com.rest.entities.User;
import com.rest.entities.UserActivity;
import com.rest.entities.UserAssessment;
import com.rest.enums.Badge;
import com.rest.enums.Role;
import com.rest.enums.Status;
import com.rest.exceptions.ActivityNotFoundException;
import com.rest.exceptions.AssessmentNotFoundException;
import com.rest.exceptions.DuplicateEntityException;
import com.rest.exceptions.UserNotFoundException;
import com.rest.service.ActivityService;
import com.rest.service.AssessmentService;
import com.rest.service.UserActivityService;
import com.rest.service.UserAssessmentService;
import com.rest.service.UserService;

@SpringBootTest
class TechLearnAppApplicationTests {

	@Autowired
	UserService userService;

	@Autowired
	ActivityService activityService;

	@Autowired
	AssessmentService assessmentService;

	@Autowired
	UserActivityService userActivityService;

	@Autowired
	UserAssessmentService userAssessmentService;

	/////////////////// user's test modules

	@Test
	public void getUserTest() {
		User u = userService.getUser("Ramanakv");
		assertEquals(u.getUserName(), "Ramanakv");
	}

	@Test
	public void saveDuplicateUser() {
		User user = new User();
		try {
			user.setUserName("Ramanakv");
			user.setPassword("sir100");
			user.setFirstName("Ramana");
			user.setLastName("Reddy");
			user.setEmailId("ramanakv@ymail.com");
			user.setRole(Role.ADMIN);
			userService.save(user);
			// throw new DuplicateEntityException("User already exist");
			Fail.fail("not checking duplicate entity");

		} catch (DuplicateEntityException de) {
			assertTrue(true);
		}
	}

	@Test
	public void saveNewUser() {
		User user = new User("kishor123", "magar123", "kishor", "magar", "kishormagar@gmail.com", Role.ADMIN);
		try {
			userService.save(user);
			assertTrue(true);
		} catch (DuplicateEntityException de) {
			Fail.fail("not checking duplicate entity");
		}
	}

	@Test
	public void deleteUser() {
		User user = new User("kishor123", "magar123", "kishor", "magar", "kishormagar@gmail.com", Role.ADMIN);
		try {
			userService.delete(user.getUserName());
			assertTrue(true);
		} catch (UserNotFoundException de) {
			Fail.fail("no entity with this userName");
		}
	}

/////////////////// Assessment's test modules

	@Test
	public void getAssessmentTest() {
		Assessment assessmentCheck = assessmentService.getAssessment(10);
		assertEquals(assessmentCheck.getAssessmentName(), "java1");
	}

	@Test
	public void saveAssessment() {
		Activity a1 = new Activity(1, "java", Date.valueOf("2013-10-12"), Date.valueOf("2013-11-12"), 30);
		Assessment check1 = new Assessment(10, "java1", Date.valueOf("2013-12-10"), 2f, "MCQ", a1);
		try {
			assessmentService.save(check1);
			Fail.fail("not checking duplicate entity");
		} catch (DuplicateEntityException dee) {
			assertTrue(true);
		}

	}

/////////////////// Activities test modules
	@Test
	public void getActivityTest() {
		Activity a = activityService.getActivity(1);
		assertEquals(a.getActivityName(), "java");
	}

	@Test
	public void saveActivityTest() {
		Activity a2 = new Activity(2, "Sql", Date.valueOf("2015-2-10"), Date.valueOf("2015-4-12"), 60);
		try {
			activityService.save(a2);
			Fail.fail("not checking duplicate entity");
		} catch (DuplicateEntityException de) {
			assertTrue(true);
		}
	}

	@Test
	public void updateActivity() {
		Activity activity = new Activity(4, "IoT", Date.valueOf("2020-10-08"), Date.valueOf("2020-11-08"), 30);
		try {
			activityService.update(activity);
			Fail.fail("Activity not found ");

		} catch (ActivityNotFoundException an) {
			assertTrue(true);
		}

	}

	@Test
	public void deleteActivityTest() {
		Activity activity = new Activity(3, "Python", Date.valueOf("2019-10-12"), Date.valueOf("2019-12-12"), 62);
		try {
			activityService.delete(3);
			assertEquals(activityService.getActivity(3),activity);
			
		} catch (ActivityNotFoundException an) {
			assertTrue(true);
		}
	}

/////////////////// userActivity test modules
	@Test
	public void getActivityById() {
		User u1 = new User("Ramanakv", "sir100", "Ramana", "Reddy", "ramanakv@ymail.com", Role.ADMIN);
		Activity a2 = new Activity(2, "Sql", Date.valueOf("2015-2-10"), Date.valueOf("2015-4-12"), 60);
		UserActivity useractivity1 = new UserActivity(Date.valueOf("2013-12-10"), Status.PASS, u1, a2);

		List<Activity> a = userActivityService.getActivityTakenByUser("Ramanakv");
		assertEquals(a.contains(a2), Boolean.FALSE);

	}

/////////////////// userAssessment test modules
	@Test
	public void getUserAssessment() {

		User u2 = new User("kavita", "mam200", "kavita", "arora", "kavitaArora@gmail.com", Role.MODERATOR);
		Activity a1 = new Activity(1, "java", Date.valueOf("2013-10-12"), Date.valueOf("2013-11-12"), 30);
		Assessment b1 = new Assessment(10, "java1", Date.valueOf("2013-12-10"), 2f, "MCQ", a1);
		UserAssessment u = new UserAssessment(80.0f, Badge.GOLD, u2, b1);

		List<UserAssessment> assess1 = userAssessmentService.getAllUserAssessment();
		assertEquals(assess1.contains(b1), Boolean.FALSE);

	}
}
