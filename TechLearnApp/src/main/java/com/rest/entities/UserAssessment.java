package com.rest.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.rest.enums.Badge;

@Entity
@Table(name = "userassessment_tbl")
public class UserAssessment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userassessmentid")
	private Integer userAssessmentId;
	private Float score;
	private Badge badge;

	@OneToOne
	@JoinColumn(name = "userid")
	private User user;

	@OneToOne
	@JoinColumn(name = "assessmentid")
	private Assessment assessment;

	public UserAssessment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserAssessment(Float score, Badge badge, User user, Assessment assessment) {
		super();

		this.score = score;
		this.badge = badge;
		this.user = user;
		this.assessment = assessment;
	}

	public Integer getUserAssessmentId() {
		return userAssessmentId;
	}

	public void setUserAssessmentId(Integer userAssessmentId) {
		this.userAssessmentId = userAssessmentId;
	}

	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	public Badge getBadge() {
		return badge;
	}

	public void setBadge(Badge badge) {
		this.badge = badge;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Assessment getAssessment() {
		return assessment;
	}

	public void setAssessment(Assessment assessment) {
		this.assessment = assessment;
	}

}