package com.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.entities.Activity;
import com.rest.entities.User;
import com.rest.enums.Badge;
import com.rest.enums.Role;
import com.rest.exceptions.NotAuthorizedException;
import com.rest.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	UserService service;

	Logger logger = LoggerFactory.getLogger(UserController.class);

	@GetMapping
	public List<User> getAll() {

		// validateToken(request);
		return service.getAllUsers();
	}

	@GetMapping("userame/{username}")
	public ResponseEntity<?> getUser(@PathVariable("username") String userName) {
		User user = service.getUser(userName);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@GetMapping("firstname/{firstname}")
	public List<User> getByFirstName(@PathVariable("firstname") String firstName) {
		return service.getByFirstName(firstName);
	}

	@GetMapping("lastname/{lastname}")
	public List<User> getByLastName(@PathVariable("lastname") String lastName) {
		return service.getByLastName(lastName);
	}

	@GetMapping("email/{emailid}")
	public List<User> getByEmailId(@PathVariable("emailid") String emailId) {
		return service.getByEmail(emailId);
	}

	@PostMapping
	public ResponseEntity<String> saveUser(@Valid @RequestBody User newUser) {
		/*Role role = user.getRole();
		if (!(role.equals("admin")))
			throw new NotAuthorizedException("Save User Data can only be done by Admin.");
		*/
		service.save(newUser);
		return new ResponseEntity<String>("User with id:" + newUser.getUserName() + " saved.", HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<String> updateUser(@Valid @RequestBody User user) {
		/*Role role = user.getRole();
		String password = user.getPassword();
		if ((role.equals("admin")))
		throw new NotAuthorizedException("Update All User Data can only be done by Admin.");

			*/
		service.update(user);
			
		return new ResponseEntity<String>("User with id:" + user.getUserName() + " sucessfully updated.",
				HttpStatus.OK);

	}

	@DeleteMapping("{userName}")
	public ResponseEntity<String> deleteUser(@PathVariable("userName") String userName) {
		/*Role role = user.getRole();
		if (!(role.equals("admin")))
			throw new NotAuthorizedException("Delete User Data can only be done by Admin.");
	*/
		service.delete(userName);
		return new ResponseEntity<String>("User with " + userName + " sucessfully deleted.", HttpStatus.OK);
	}
}
