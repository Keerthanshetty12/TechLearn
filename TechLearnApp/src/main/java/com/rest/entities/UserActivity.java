package com.rest.entities;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.rest.enums.Status;

@Entity
@Table(name = "useractivity_tbl")
public class UserActivity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "useractivityid")
	private Integer userAvtivityId;
	private Date startDate;
	private Status status;
	
	@OneToOne
	@JoinColumn(name = "userid")
	private User user;

	@OneToOne
	@JoinColumn(name = "activityid")
	private Activity activity;
	
	
	public UserActivity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public UserActivity(Date startDate, Status status, User user, Activity activity) {
		super();
	
		this.startDate = startDate;
		this.status = status;
		this.user = user;
		this.activity = activity;
	}


	public Integer getUserAvtivityId() {
		return userAvtivityId;
	}


	public void setUserAvtivityId(Integer userAvtivityId) {
		this.userAvtivityId = userAvtivityId;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Activity getActivity() {
		return activity;
	}


	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	
	
}
