package com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.entities.Assessment;
import com.rest.service.AssessmentService;

@RestController
@RequestMapping("assessment")
public class AssessmentController {

	@Autowired
	AssessmentService assessmentService;

	@GetMapping("{assessmentid}")
	public ResponseEntity<?> getAssessment(@PathVariable("assessmentid") Integer assessmentId) {
			Assessment x = assessmentService.getAssessment(assessmentId);
		return new ResponseEntity<Assessment>(x, HttpStatus.OK);
	}

	@GetMapping
	public List<Assessment> getAll() {
		return assessmentService.getAllAssessment();
	}

	@PostMapping
	public ResponseEntity<String> saveAssessment(@RequestBody Assessment a) {
		assessmentService.save(a);

		return new ResponseEntity<String>("Assessment with ID " + a.getAssessmentId() + " successfully saved",
				HttpStatus.CREATED);

	}

	@DeleteMapping("{assessmentId}")
	public ResponseEntity<String> deleteAssessment(@PathVariable("assessmentId") Integer assessmentId) {
		assessmentService.delete(assessmentId);

		return new ResponseEntity<String>("Assessment with ID " + assessmentId + " successfully deleted",
				HttpStatus.OK);
	}

}