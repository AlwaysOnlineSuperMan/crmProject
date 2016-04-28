package com.hr.entityXX;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ConfigMajorKind entity. @author MyEclipse Persistence Tools
 */

public class ConfigMajorKind implements java.io.Serializable {

	// Fields

	private Short mfkId;
	private String majorKindName;
	private String majorKindId;
	private Date updateDateTime;
	private Set configMajors = new HashSet(0);

	// Constructors

	/** default constructor */
	public ConfigMajorKind() {
	}

	/** full constructor */
	public ConfigMajorKind(String majorKindName, String majorKindId,
			Date updateDateTime, Set configMajors) {
		this.majorKindName = majorKindName;
		this.majorKindId = majorKindId;
		this.updateDateTime = updateDateTime;
		this.configMajors = configMajors;
	}

	// Property accessors

	public Short getMfkId() {
		return this.mfkId;
	}

	public void setMfkId(Short mfkId) {
		this.mfkId = mfkId;
	}

	public String getMajorKindName() {
		return this.majorKindName;
	}

	public void setMajorKindName(String majorKindName) {
		this.majorKindName = majorKindName;
	}

	public String getMajorKindId() {
		return this.majorKindId;
	}

	public void setMajorKindId(String majorKindId) {
		this.majorKindId = majorKindId;
	}

	public Date getUpdateDateTime() {
		return this.updateDateTime;
	}

	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	public Set getConfigMajors() {
		return this.configMajors;
	}

	public void setConfigMajors(Set configMajors) {
		this.configMajors = configMajors;
	}

}