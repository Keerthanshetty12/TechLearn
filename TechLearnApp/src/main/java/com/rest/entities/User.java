package com.rest.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import com.rest.enums.Badge;
import com.rest.enums.Role;

@Entity
@Table(name = "user_tbl")
public class User {
	
	@Id
	@Column(name = "username",length = 20)
	private String userName;
	
	@Column(name = "password",length = 20)
	private String password;
	
	@Column(name = "firstname",length = 20)
	private String firstName;
	
	@Column(name = "lastname",length = 20)
	private String lastName;
	
	@Column(name = "emailid",length = 30)
	private String emailId;
	
	private Role role;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User( String userName, String password, String firstName, String lastName, String emailId,
			Role role) {
		super();
		
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.role = role;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	

}
