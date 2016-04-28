package com.hr.entityXX;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ConfigQuestionFirstKind entity. @author MyEclipse Persistence Tools
 */

public class ConfigQuestionFirstKind implements java.io.Serializable {

	// Fields

	private Short qfkId;
	private String firstKindId;
	private String firstKindName;
	private Date updateDateTime;
	private Set configQuestionSecondKinds = new HashSet(0);

	// Constructors

	/** default constructor */
	public ConfigQuestionFirstKind() {
	}

	/** full constructor */
	public ConfigQuestionFirstKind(String firstKindId, String firstKindName,
			Date updateDateTime, Set configQuestionSecondKinds) {
		this.firstKindId = firstKindId;
		this.firstKindName = firstKindName;
		this.updateDateTime = updateDateTime;
		this.configQuestionSecondKinds = configQuestionSecondKinds;
	}

	// Property accessors

	public Short getQfkId() {
		return this.qfkId;
	}

	public void setQfkId(Short qfkId) {
		this.qfkId = qfkId;
	}

	public String getFirstKindId() {
		return this.firstKindId;
	}

	public void setFirstKindId(String firstKindId) {
		this.firstKindId = firstKindId;
	}

	public String getFirstKindName() {
		return this.firstKindName;
	}

	public void setFirstKindName(String firstKindName) {
		this.firstKindName = firstKindName;
	}

	public Date getUpdateDateTime() {
		return this.updateDateTime;
	}

	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	public Set getConfigQuestionSecondKinds() {
		return this.configQuestionSecondKinds;
	}

	public void setConfigQuestionSecondKinds(Set configQuestionSecondKinds) {
		this.configQuestionSecondKinds = configQuestionSecondKinds;
	}

}