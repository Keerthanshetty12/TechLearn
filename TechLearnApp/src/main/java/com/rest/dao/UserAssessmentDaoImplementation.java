package com.rest.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.entities.Assessment;
import com.rest.entities.UserAssessment;
import com.rest.exceptions.AssessmentNotFoundException;
import com.rest.exceptions.NoDataException;

import com.rest.exceptions.UserNotFoundException;
import com.rest.repository.UserAssessmentRepository;

@Service
public class UserAssessmentDaoImplementation implements UserAssessmentDao {

	@Autowired
	UserAssessmentRepository userAssessmentRepository;

	@Override
	public UserAssessment getUserAssessment(Integer userAssessmentId) throws AssessmentNotFoundException {
		Optional<UserAssessment> opt = userAssessmentRepository.findById(userAssessmentId);
		if (opt.isPresent()) {
			UserAssessment a = opt.get();
			return a;
		} else {
			throw new AssessmentNotFoundException("Activity with ID " + userAssessmentId + " not found");
		}
	}

	@Override
	public void saveUserAssessment(UserAssessment u) throws UserNotFoundException {
		if (!userAssessmentRepository.existsById(u.getUserAssessmentId()))
			throw new UserNotFoundException("Assessment with " + u.getUserAssessmentId() + " not found to save");
		userAssessmentRepository.save(u);
	}

	@Override
	public List<UserAssessment> getAllUserAssessment() throws NoDataException {
		List<UserAssessment> list = userAssessmentRepository.findAll();
		if (list.size() == 0)
			throw new NoDataException("No UserAssessment exists in the database");
		return list;
	}

	@Override
	public List<Assessment> getAssessmentsTakenByUser(String UserName) throws NoDataException {
		return userAssessmentRepository.getAssessmentsTakenByUser(UserName);
	}

}
