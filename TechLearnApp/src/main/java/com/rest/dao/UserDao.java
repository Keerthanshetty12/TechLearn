package com.rest.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rest.entities.User;
import com.rest.exceptions.DuplicateEntityException;
import com.rest.exceptions.NoDataException;
import com.rest.exceptions.UserNotFoundException;

@Service
public interface UserDao {
	List<User> getByFnm(String firstName) throws UserNotFoundException;

	List<User> getByLastName(String lastName) throws UserNotFoundException;

	List<User> getByEmailId(String emialId) throws UserNotFoundException;

	User getUser(String userName) throws UserNotFoundException;
	
	List<User> getAllUsers() throws NoDataException;

	void updateUser(User user) throws UserNotFoundException;

	void deleteUser(String userName) throws UserNotFoundException;

	void saveUser(User user) throws DuplicateEntityException;
}
