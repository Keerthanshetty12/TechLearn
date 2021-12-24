package com.rest.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rest.entities.Assessment;
import com.rest.entities.UserAssessment;
import com.rest.exceptions.AssessmentNotFoundException;
import com.rest.exceptions.NoDataException;
import com.rest.exceptions.UserNotFoundException;


@Service
public interface UserAssessmentDao {
	
	UserAssessment getUserAssessment(Integer userAssessmentId) throws UserNotFoundException;
	
	void saveUserAssessment(UserAssessment u) throws AssessmentNotFoundException;
	
	List<UserAssessment> getAllUserAssessment() throws NoDataException;
	
	List<Assessment> getAssessmentsTakenByUser(String UserName)throws NoDataException;
	
	

}