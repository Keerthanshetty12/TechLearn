package com.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.dao.UserDao;
import com.rest.entities.User;

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	UserDao dao;

	@Override
	public User getUser(String userName) {
		// TODO Auto-generated method stub
		return dao.getUser(userName);
	}

	@Override
	public void save(User u) {
		// TODO Auto-generated method stub
		dao.saveUser(u);
		}

	@Override
	public void update(User u) {
		// TODO Auto-generated method stub
		dao.updateUser(u);
	}

	@Override
	public void delete(String userName) {
		// TODO Auto-generated method stub
		dao.deleteUser(userName);
	}

	@Override
	public List<User> getByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return dao.getByFnm(firstName);
	}

	@Override
	public List<User> getByLastName(String LastName) {
		// TODO Auto-generated method stub
		return dao.getByLastName(LastName);
	}

	@Override
	public List<User> getByEmail(String emailId) {
		// TODO Auto-generated method stub
		return dao.getByEmailId(emailId);
	}


	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return dao.getAllUsers();
	}

}
