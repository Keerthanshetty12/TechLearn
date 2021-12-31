package com.rest.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.entities.User;
import com.rest.exceptions.DuplicateEntityException;
import com.rest.exceptions.NoDataException;
import com.rest.exceptions.UserNotFoundException;
import com.rest.repository.UserRepository;

@Service
public class UserDaoImplementation implements UserDao {

	@Autowired
	UserRepository userRepository;

	@Override
	public User getUser(String username) throws UserNotFoundException {
		Optional<User> opt = userRepository.findById(username);
		if (opt.isPresent()) {
			User u = opt.get();
			return u;
		} else {
			throw new UserNotFoundException("User with id:" + username + " not found");
		}
	}

	@Override
	public void updateUser(User user) throws UserNotFoundException {
		if (!userRepository.existsById(user.getUserName()))
			throw new UserNotFoundException("User with " + user.getUserName() + " not found to update");
		userRepository.save(user);

	}

	@Override
	public void deleteUser(String userName) throws UserNotFoundException {
		if (!userRepository.existsById(userName))
			throw new UserNotFoundException("User with " + userName + " not found to delete");
		userRepository.deleteById(userName);
		;

	}

	@Override
	public void saveUser(User user) throws DuplicateEntityException {
		if (userRepository.existsById(user.getUserName()))
			throw new DuplicateEntityException("User with id: " + user.getUserName() + "already exist");
		userRepository.save(user);

	}

	@Override
	public List<User> getByFnm(String firstName) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return userRepository.getByFnm(firstName);
	}

	@Override
	public List<User> getByLastName(String lastName) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return userRepository.getByLastName(lastName);
	}

	@Override
	public List<User> getByEmailId(String emailId) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return userRepository.getByEmailId(emailId);
	}

	@Override
	public List<User> getAllUsers() throws NoDataException {
		return userRepository.findAll();
		
	}

}
