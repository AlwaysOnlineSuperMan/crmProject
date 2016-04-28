package com.hr.entityXX;

import java.util.Date;

/**
 * ConfigQuestionSecondKind entity. @author MyEclipse Persistence Tools
 */

public class ConfigQuestionSecondKind implements java.io.Serializable {

	// Fields

	private Short qskId;
	private ConfigQuestionFirstKind configQuestionFirstKind;
	private String firstKindName;
	private String secondKindId;
	private String secondKindName;
	private Date updateDateTime;

	// Constructors

	/** default constructor */
	public ConfigQuestionSecondKind() {
	}

	/** full constructor */
	public ConfigQuestionSecondKind(
			ConfigQuestionFirstKind configQuestionFirstKind,
			String firstKindName, String secondKindId, String secondKindName,
			Date updateDateTime) {
		this.configQuestionFirstKind = configQuestionFirstKind;
		this.firstKindName = firstKindName;
		this.secondKindId = secondKindId;
		this.secondKindName = secondKindName;
		this.updateDateTime = updateDateTime;
	}

	// Property accessors

	public Short getQskId() {
		return this.qskId;
	}

	public void setQskId(Short qskId) {
		this.qskId = qskId;
	}

	public ConfigQuestionFirstKind getConfigQuestionFirstKind() {
		return this.configQuestionFirstKind;
	}

	public void setConfigQuestionFirstKind(
			ConfigQuestionFirstKind configQuestionFirstKind) {
		this.configQuestionFirstKind = configQuestionFirstKind;
	}

	public String getFirstKindName() {
		return this.firstKindName;
	}

	public void setFirstKindName(String firstKindName) {
		this.firstKindName = firstKindName;
	}

	public String getSecondKindId() {
		return this.secondKindId;
	}

	public void setSecondKindId(String secondKindId) {
		this.secondKindId = secondKindId;
	}

	public String getSecondKindName() {
		return this.secondKindName;
	}

	public void setSecondKindName(String secondKindName) {
		this.secondKindName = secondKindName;
	}

	public Date getUpdateDateTime() {
		return this.updateDateTime;
	}

	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

}