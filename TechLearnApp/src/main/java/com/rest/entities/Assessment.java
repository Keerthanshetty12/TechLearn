package com.rest.entities;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;





@Entity
@Table(name = "assessment_tbl")
public class Assessment {

	@Id
	@Column(name = "assessmentid")
	private Integer assessmentId;
	@Column(name = "assessmentname",length=20)
	private String assessmentName;
	private Date releaseDate;
	private Float duration;
	@Column(name = "type",length=20)
	private String type;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "activity_fk")
	private Activity activity;
	
	public Assessment() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Assessment(Integer assessmentId, String assessmentName, Date releaseDate, Float duration, String type,
			Activity activity) {
		super();
		this.assessmentId = assessmentId;
		this.assessmentName = assessmentName;
		this.releaseDate = releaseDate;
		this.duration = duration;
		this.type = type;
		this.activity = activity;
	}


	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}


	public Integer getAssessmentId() {
		return assessmentId;
	}

	public void setAssessmentId(Integer assessmentId) {
		this.assessmentId = assessmentId;
	}

	public String getAssessmentName() {
		return assessmentName;
	}

	public void setAssessmentName(String assessmentName) {
		this.assessmentName = assessmentName;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Float getDuration() {
		return duration;
	}

	public void setDuration(Float duration) {
		this.duration = duration;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	

}
