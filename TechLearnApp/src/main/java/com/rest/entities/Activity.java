package com.rest.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name = "activity_tbl")
public class Activity {
	@Id
	@Column(name="activityId")
	private Integer activityId;
	@Column(name="activityname",length = 20)
	private String activityName;
	private Date startDate;
	private Date endDate;
	private Integer duration;
	
	/*
	@OneToMany(mappedBy = "activity")
	@JsonIgnore
	List<Assessment> assessment = new ArrayList<>();
	*/
	public Activity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Activity(Integer activityId, String activityName, Date startDate, Date endDate, Integer duration) {
		super();
		this.activityId = activityId;
		this.activityName = activityName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.duration = duration;
	}


	public Integer getActivityId() {
		return activityId;
	}


	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}


	public String getActivityName() {
		return activityName;
	}


	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public Integer getDuration() {
		return duration;
	}


	public void setDuration(Integer duration) {
		this.duration = duration;
	}


	

}
