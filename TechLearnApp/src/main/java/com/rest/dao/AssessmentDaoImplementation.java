package com.rest.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.entities.Assessment;
import com.rest.exceptions.AssessmentNotFoundException;
import com.rest.exceptions.DuplicateEntityException;
import com.rest.exceptions.NoDataException;
import com.rest.repository.AssessmentRepository;

@Service
public class AssessmentDaoImplementation implements AssessmentDao {
	@Autowired
	AssessmentRepository assessmentRepository;
	
	@Override
	public Assessment getAssessment(Integer assessmentId) throws AssessmentNotFoundException {

		Optional<Assessment> opt = assessmentRepository.findById(assessmentId);
		if (opt.isPresent()) {
			Assessment a = opt.get();
			return a;
		} else {
			throw new AssessmentNotFoundException("Assessment with id " + assessmentId + "not found");
		}
	}

	@Override
	public List<Assessment> getAllAssessment() throws NoDataException {
		List<Assessment> list = assessmentRepository.findAll();
		//System.out.println(list.size());
		if (list.size() == 0)
			throw new NoDataException("No assessment exists in the database");
		return list;
	}

	@Override
	public void deleteAssessment(Integer assessmentId) throws AssessmentNotFoundException {
		if (!(assessmentRepository.existsById(assessmentId)))
			throw new AssessmentNotFoundException("Assessment with id " + assessmentId + "not found to delete");
		assessmentRepository.deleteById(assessmentId);

	}

	@Override
	public void saveAssessment(Assessment a) throws DuplicateEntityException {
		if (assessmentRepository.existsById(a.getAssessmentId()))
			throw new DuplicateEntityException("Assessment with id " + a.getAssessmentId() + " already exists");
		assessmentRepository.save(a);
	}

	@Override
	public List<Assessment> getByName(String assessmentName)throws AssessmentNotFoundException {	
		return assessmentRepository.getByName(assessmentName);
	}

}