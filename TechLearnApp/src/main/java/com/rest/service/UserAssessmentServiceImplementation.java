package com.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.dao.UserAssessmentDao;
import com.rest.entities.Assessment;
import com.rest.entities.UserAssessment;

@Service
public class UserAssessmentServiceImplementation implements UserAssessmentService {

	@Autowired
	UserAssessmentDao dao;

	@Override
	public void save(UserAssessment userAssesssment) {

		dao.saveUserAssessment(userAssesssment);

	}

	@Override
	public UserAssessment getUserAssessment(Integer userAssessmentId) {
		// TODO Auto-generated method stub
		return dao.getUserAssessment(userAssessmentId);
	}

	@Override
	public List<UserAssessment> getAllUserAssessment() {
		// TODO Auto-generated method stub
		return dao.getAllUserAssessment();
	}

	@Override
	public List<Assessment> getAssessmentsTakenByUser(String userName) {
		// TODO Auto-generated method stub
		return dao.getAssessmentsTakenByUser(userName);
	}

}
