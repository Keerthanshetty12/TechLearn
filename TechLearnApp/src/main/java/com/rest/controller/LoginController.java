package com.rest.controller;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.entities.User;
import com.rest.exceptions.LoginException;

import com.rest.jwt.LoginData;
import com.rest.repository.UserRepository;

@RestController

@RequestMapping("/login")
public class LoginController {
	@Autowired
	UserRepository repository;
	
	
	@PostMapping
	public ResponseEntity<?> login(@RequestBody LoginData data){
		String username=data.getUsername();
		String password=data.getPassword();
		
		Optional<User> opt=repository.findById(username);
		if(!opt.isPresent())
			throw new LoginException("Invalid user name");
		
		User user=opt.get();
		if(!(user.getPassword().equals(password)))
			throw new LoginException("Invalid password");
		
		String tocken="Login Sucessfull";
		return new ResponseEntity<String>(tocken,HttpStatus.OK);
	}
}
