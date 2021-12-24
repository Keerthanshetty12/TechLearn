package com.rest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rest.entities.Assessment;

@Service
public interface AssessmentService {

	Assessment getAssessment(Integer assessmentId);

	List<Assessment> getAllAssessment();

	void save(Assessment a);

	void delete(Integer assessmentId);

	List<Assessment> getByName(String assessmentName);

}
