package com.hr.entityXX;

import java.util.Date;

/**
 * EngageAnswerDetails entity. @author MyEclipse Persistence Tools
 */

public class EngageAnswerDetails implements java.io.Serializable {

	// Fields

	private Short andId;
	private EngageAnswer engageAnswer;
	private Short subjectId;
	private String answer;
	private Date updateDateTime;

	// Constructors

	/** default constructor */
	public EngageAnswerDetails() {
	}

	/** full constructor */
	public EngageAnswerDetails(EngageAnswer engageAnswer, Short subjectId,
			String answer, Date updateDateTime) {
		this.engageAnswer = engageAnswer;
		this.subjectId = subjectId;
		this.answer = answer;
		this.updateDateTime = updateDateTime;
	}

	// Property accessors

	public Short getAndId() {
		return this.andId;
	}

	public void setAndId(Short andId) {
		this.andId = andId;
	}

	public EngageAnswer getEngageAnswer() {
		return this.engageAnswer;
	}

	public void setEngageAnswer(EngageAnswer engageAnswer) {
		this.engageAnswer = engageAnswer;
	}

	public Short getSubjectId() {
		return this.subjectId;
	}

	public void setSubjectId(Short subjectId) {
		this.subjectId = subjectId;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Date getUpdateDateTime() {
		return this.updateDateTime;
	}

	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

}