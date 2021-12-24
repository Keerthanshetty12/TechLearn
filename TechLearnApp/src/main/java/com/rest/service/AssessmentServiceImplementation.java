package com.rest.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.dao.AssessmentDao;
import com.rest.entities.Assessment;

@Service
public class AssessmentServiceImplementation implements AssessmentService{
	
    @Autowired
	AssessmentDao dao;
	
	@Override
	public Assessment getAssessment(Integer assessmentId) {
		return dao.getAssessment(assessmentId);
		
	}

	@Override
	public List<Assessment> getAllAssessment() {
		return dao.getAllAssessment();
	}

	@Override
	public void save(Assessment a) {
		dao.saveAssessment(a);
	}

	@Override
	public void delete(Integer assessmentId) {
		dao.deleteAssessment(assessmentId);
		
	}

	@Override
	public List<Assessment> getByName(String assessmentName) {
		return dao.getByName(assessmentName);
	}

	

	
}