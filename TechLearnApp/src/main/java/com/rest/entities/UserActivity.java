package com.rest.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import com.rest.dao.UserActivityDaoImplementation;
import com.rest.enums.Status;
import com.rest.service.UserService;

@Entity
@Table(name = "useractivity_tbl")
public class UserActivity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "useractivityid")
	private Integer userActivityId;
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
	}


	public UserActivity(Date startDate, Status status, User user, Activity activity) {
		super();
	
		this.startDate = startDate;
		this.status = status;
		this.user = user;
		this.activity = activity;
	}
	


	public Integer getUserActivityId() {
		return userActivityId;
	}


	public void setUserActivityId(Integer userActivityId) {
		this.userActivityId = userActivityId;
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
		
		this.user=user;
	}


	public Activity getActivity() {
		return activity;
	}


	public void setActivity(Activity activity) {
		System.out.print(activity);
		this.activity=activity;
	}


	

	
	
}
