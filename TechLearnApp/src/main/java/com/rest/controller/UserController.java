package com.rest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.entities.Response;
import com.rest.entities.User;
import com.rest.enums.Role;
import com.rest.exceptions.NotAuthorizedException;
import com.rest.jwt.JwtTokenUtil;
import com.rest.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("user")
public class UserController {
	@Autowired
	UserService service;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	User user;
	User change=new User();
	Logger logger = LoggerFactory.getLogger(UserController.class);

	@GetMapping
	public List<User> getAll(HttpServletRequest request) {
		user = jwtTokenUtil.validateTokenAndGetUserDetails(request);
		
		Role role=user.getRole();
		if(!(role==Role.ADMIN)) {
		throw new NotAuthorizedException("Only Admin can View All Details.");
		//return new ResponseEntity<Response>(
			//	new Response("Only Admin can create New User."),HttpStatus.NON_AUTHORITATIVE_INFORMATION);
		}
		logger.info("list of all users");
		return service.getAllUsers();
		
	}

	@GetMapping("/userName{username}")
	public ResponseEntity<?> getUser(@RequestBody @PathVariable("username") String userName) {
		User user = service.getUser(userName);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@GetMapping("/firstname{firstname}")
	public List<User> getByFirstName(@PathVariable("firstname") String firstName) {
		return service.getByFirstName(firstName);
	}

	@GetMapping("/lastname{lastname}")
	public List<User> getByLastName(@PathVariable("lastname") String lastName) {
		return service.getByLastName(lastName);
	}

	@GetMapping("/email{emailid}")
	public List<User> getByEmailId(@PathVariable("emailid") String emailId) {
		return service.getByEmail(emailId);
	}

	@PostMapping
	public ResponseEntity<?> saveUser(@Valid @RequestBody User newUser,HttpServletRequest request) {
		user = jwtTokenUtil.validateTokenAndGetUserDetails(request);
		
		Role role=user.getRole();
		if(!(role==Role.ADMIN))
		{
			//throw new NotAuthorizedException("Only Admin can create New User.");
		return new ResponseEntity<Response>(
				new Response("Only Admin can create New User."),HttpStatus.NON_AUTHORITATIVE_INFORMATION);
		}
		
		change.setUserName(newUser.getUserName());
		change.setPassword(newUser.getPassword());
		change.setFirstName(newUser.getFirstName());
		change.setLastName(newUser.getLastName());
		change.setEmailId(newUser.getEmailId());
		
		switch(String.valueOf(newUser.getRole()))
		{
		case "ADMIN":change.setRole(Role.ADMIN);
					break;
		case "USER":change.setRole(Role.USER);
					break;
		case "MODERATOR":change.setRole(Role.MODERATOR);
					break;
		}
		System.out.println(newUser.getRole());
		service.save(change);
		return new ResponseEntity<Response>(
				new Response("user data successfully saved"),HttpStatus.OK);
		}

	@PutMapping
	public ResponseEntity<?> updateUser(@Valid @RequestBody User user) {
		System.out.println(user);
		service.update(user);
		return new ResponseEntity<Response>(new Response("User with id:" + user.getUserName() + " sucessfully updated."),
				HttpStatus.OK);

	}

	@DeleteMapping("/userName{userName}")
	public ResponseEntity<?> deleteUser(@PathVariable("userName") String userName) {
		service.delete(userName);
		return new ResponseEntity<Response>(
				new Response("user data with userName: "+ userName + " successfully deleted"),HttpStatus.OK);
}
	
}
