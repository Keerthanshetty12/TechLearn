package com.rest.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.rest.entities.Assessment;
import com.rest.entities.UserAssessment;

@Service
public interface UserAssessmentService {
	
	UserAssessment getUserAssessment(Integer userAssessmentId);

	List<UserAssessment> getAllUserAssessment();
	
	List<Assessment> getAssessmentsTakenByUser(String userName);
	
	void save(UserAssessment userAssesssment );

}
