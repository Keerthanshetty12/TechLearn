package com.rest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.entities.Assessment;
import com.rest.entities.Response;
import com.rest.entities.UserAssessment;
import com.rest.service.UserAssessmentService;

@RestController
@RequestMapping("userassessment")
@CrossOrigin(origins = "http://localhost:4200")
public class UserAssessmentController {

	@Autowired
	UserAssessmentService userAssessmentService;

	
	Logger logger = LoggerFactory.getLogger(UserAssessmentController.class);

	@GetMapping("{userassessmentid}")
	public ResponseEntity<?> getUserAssessment(@PathVariable("userassessmentid") Integer userAssessmentId) {
		UserAssessment r = userAssessmentService.getUserAssessment(userAssessmentId);
		return new ResponseEntity<UserAssessment>(r, HttpStatus.OK);
	}

	@GetMapping("userName/{username}")
	public List<Assessment> getUsers(@PathVariable("username") String userName) {
		List<Assessment> r = userAssessmentService.getAssessmentsTakenByUser(userName);
		return r;
	}

	@GetMapping
	public List<UserAssessment> getAll() {
		logger.info("Assessment of all users");
		return userAssessmentService.getAllUserAssessment();
	}

	@PostMapping
	public ResponseEntity<Response> saveUserAssessment(@RequestBody UserAssessment userassessment) {
		/*Role role = user.getRole();
		if (!(role.equals("admin")||(role.equals("moderator"))))
			throw new NotAuthorizedException("create Assessment Data can only be done by Admin and Moderator.");
*/
		userAssessmentService.save(userassessment);
		logger.info("user saved");
		return new ResponseEntity<Response>(new Response("Assessment for user" + userassessment.getUserAssessmentId()+ " successfully saved"),
				HttpStatus.CREATED);
	}

}