package com.hr.entityXX;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ConfigMajor entity. @author MyEclipse Persistence Tools
 */

public class ConfigMajor implements java.io.Serializable {

	// Fields

	private Short makId;
	private ConfigMajorKind configMajorKind;
	private String majorKindName;
	private String majorId;
	private String majorName;
	private Short testAmount;
	private Date updateDateTime;
	private Set humanFileDigs = new HashSet(0);
	private Set humanFiles = new HashSet(0);
	private Set engageExams = new HashSet(0);

	// Constructors

	/** default constructor */
	public ConfigMajor() {
	}

	/** full constructor */
	public ConfigMajor(ConfigMajorKind configMajorKind, String majorKindName,
			String majorId, String majorName, Short testAmount,
			Date updateDateTime, Set humanFileDigs, Set humanFiles,
			Set engageExams) {
		this.configMajorKind = configMajorKind;
		this.majorKindName = majorKindName;
		this.majorId = majorId;
		this.majorName = majorName;
		this.testAmount = testAmount;
		this.updateDateTime = updateDateTime;
		this.humanFileDigs = humanFileDigs;
		this.humanFiles = humanFiles;
		this.engageExams = engageExams;
	}

	// Property accessors

	public Short getMakId() {
		return this.makId;
	}

	public void setMakId(Short makId) {
		this.makId = makId;
	}

	public ConfigMajorKind getConfigMajorKind() {
		return this.configMajorKind;
	}

	public void setConfigMajorKind(ConfigMajorKind configMajorKind) {
		this.configMajorKind = configMajorKind;
	}

	public String getMajorKindName() {
		return this.majorKindName;
	}

	public void setMajorKindName(String majorKindName) {
		this.majorKindName = majorKindName;
	}

	public String getMajorId() {
		return this.majorId;
	}

	public void setMajorId(String majorId) {
		this.majorId = majorId;
	}

	public String getMajorName() {
		return this.majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public Short getTestAmount() {
		return this.testAmount;
	}

	public void setTestAmount(Short testAmount) {
		this.testAmount = testAmount;
	}

	public Date getUpdateDateTime() {
		return this.updateDateTime;
	}

	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	public Set getHumanFileDigs() {
		return this.humanFileDigs;
	}

	public void setHumanFileDigs(Set humanFileDigs) {
		this.humanFileDigs = humanFileDigs;
	}

	public Set getHumanFiles() {
		return this.humanFiles;
	}

	public void setHumanFiles(Set humanFiles) {
		this.humanFiles = humanFiles;
	}

	public Set getEngageExams() {
		return this.engageExams;
	}

	public void setEngageExams(Set engageExams) {
		this.engageExams = engageExams;
	}

}