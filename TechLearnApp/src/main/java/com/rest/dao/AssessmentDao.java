package com.rest.dao;

	import java.util.List;

	import org.springframework.stereotype.Service;

import com.rest.entities.Assessment;
import com.rest.exceptions.AssessmentNotFoundException;
import com.rest.exceptions.DuplicateEntityException;
import com.rest.exceptions.NoDataException;


	@Service
	public interface AssessmentDao {

		Assessment getAssessment(Integer assessmentId) throws AssessmentNotFoundException;
		
		List<Assessment> getByName (String assessmentName)throws AssessmentNotFoundException;
		
		List<Assessment> getAllAssessment() throws NoDataException;
		
		void deleteAssessment(Integer assessmentId ) throws  AssessmentNotFoundException;
		
		void saveAssessment(Assessment a) throws DuplicateEntityException;
		
		
		
	}
