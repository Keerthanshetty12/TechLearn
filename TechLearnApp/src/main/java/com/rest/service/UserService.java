package com.rest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rest.entities.User;
import com.rest.enums.Badge;

@Service
public interface UserService {
	User getUser(String userName);
	
	void save(User u);

	void update(User u);

	void delete(String userId);
	
	List<User> getByFirstName(String FirstName);
	
	List<User> getByLastName(String LastName);

	List<User> getByEmail(String emailId);

	List<User> getAllUsers();

}
