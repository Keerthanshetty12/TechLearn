package com.rest;

import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.rest.entities.Activity;
import com.rest.entities.Assessment;
import com.rest.entities.User;
import com.rest.entities.UserActivity;
import com.rest.entities.UserAssessment;
import com.rest.enums.Badge;
import com.rest.enums.Role;
import com.rest.enums.Status;
import com.rest.repository.ActivityRepository;
import com.rest.repository.AssessmentRepository;
import com.rest.repository.UserActivityRepository;
import com.rest.repository.UserAssessmentRepository;
import com.rest.repository.UserRepository;

@Service
public class DataInit implements CommandLineRunner {
	@Autowired
	UserRepository userRepo;
	@Autowired
	ActivityRepository activityRepo;
	@Autowired
	AssessmentRepository assessmentRepo;
	@Autowired
	UserActivityRepository userActivityRepo;
	@Autowired
	UserAssessmentRepository userAssessmentRepo;
	
	
	
	Logger logger=LoggerFactory.getLogger(DataInit.class);
	@Override
	public void run(String... args) throws Exception {
		
		logger.info("Database started");

		User u3=userRepo.save(new User("nagaraj","sir300","nagaraj","kumar","dsnagaraj@gmail.com",Role.USER));
		User u2=userRepo.save(new User("kavita","mam200","kavita","arora","kavitaArora@gmail.com",Role.MODERATOR));
		User u1=userRepo.save(new User("Ramanakv","sir100","Ramana","Reddy","ramanakv@ymail.com",Role.ADMIN));
		
		logger.info("3 rows inserted into user table");
	
		Activity a1=new Activity(1,"java",Date.valueOf("2013-10-12"),Date.valueOf("2013-11-12"),30);
		activityRepo.save(a1);
		Activity a2=new Activity(2,"Sql",Date.valueOf("2015-2-10"),Date.valueOf("2015-4-12"),60);
		activityRepo.save(a2);
		logger.info("2 rows inserted into Activity table");
		
		Assessment b1=assessmentRepo.save(new Assessment(10,"java1",Date.valueOf("2013-12-10"),2f,"MCQ",a1));
		Assessment b2=assessmentRepo.save(new Assessment(20,"sql1",Date.valueOf("2015-5-10"),3f,"MCQ",a2));
		Assessment b3=assessmentRepo.save(new Assessment(30,"java2",Date.valueOf("2014-1-2"),3f,"lab",a1));
		logger.info("3 rows inserted into assessment table");
		
		userAssessmentRepo.save(new UserAssessment(80.0f,Badge.GOLD,u2,b1));
		userAssessmentRepo.save(new UserAssessment(89.0f,Badge.DIAMOND,u1,b3));
		userAssessmentRepo.save(new UserAssessment(45.0f,Badge.BRONZE,u3,b2));
		logger.info("3 rows inserted into userAssessment table");
		
		userActivityRepo.save(new UserActivity(Date.valueOf("2013-12-10"),Status.PASS,u2,a1));
		userActivityRepo.save(new UserActivity(Date.valueOf("2013-12-10"),Status.FAIL,u1,a2));
		userActivityRepo.save(new UserActivity(Date.valueOf("2013-12-10"),Status.PASS,u3,a1));
		logger.info("3 rows inserted into userActivity table");
		
	}
}
