package com.hr.entityXX;

import java.sql.Timestamp;
import java.util.Date;

/**
 * EngageExam entity. @author MyEclipse Persistence Tools
 */

public class EngageExam implements java.io.Serializable {

	// Fields

	private Short exaId;
	private ConfigMajor configMajor;
	private String examNumber;
	private String majorKindId;
	private String majorKindName;
	private String majorName;
	private String register;
	private Timestamp registTime;
	private Short limiteTime;
	private Date updateDateTime;

	// Constructors

	/** default constructor */
	public EngageExam() {
	}

	/** full constructor */
	public EngageExam(ConfigMajor configMajor, String examNumber,
			String majorKindId, String majorKindName, String majorName,
			String register, Timestamp registTime, Short limiteTime,
			Date updateDateTime) {
		this.configMajor = configMajor;
		this.examNumber = examNumber;
		this.majorKindId = majorKindId;
		this.majorKindName = majorKindName;
		this.majorName = majorName;
		this.register = register;
		this.registTime = registTime;
		this.limiteTime = limiteTime;
		this.updateDateTime = updateDateTime;
	}

	// Property accessors

	public Short getExaId() {
		return this.exaId;
	}

	public void setExaId(Short exaId) {
		this.exaId = exaId;
	}

	public ConfigMajor getConfigMajor() {
		return this.configMajor;
	}

	public void setConfigMajor(ConfigMajor configMajor) {
		this.configMajor = configMajor;
	}

	public String getExamNumber() {
		return this.examNumber;
	}

	public void setExamNumber(String examNumber) {
		this.examNumber = examNumber;
	}

	public String getMajorKindId() {
		return this.majorKindId;
	}

	public void setMajorKindId(String majorKindId) {
		this.majorKindId = majorKindId;
	}

	public String getMajorKindName() {
		return this.majorKindName;
	}

	public void setMajorKindName(String majorKindName) {
		this.majorKindName = majorKindName;
	}

	public String getMajorName() {
		return this.majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public String getRegister() {
		return this.register;
	}

	public void setRegister(String register) {
		this.register = register;
	}

	public Timestamp getRegistTime() {
		return this.registTime;
	}

	public void setRegistTime(Timestamp registTime) {
		this.registTime = registTime;
	}

	public Short getLimiteTime() {
		return this.limiteTime;
	}

	public void setLimiteTime(Short limiteTime) {
		this.limiteTime = limiteTime;
	}

	public Date getUpdateDateTime() {
		return this.updateDateTime;
	}

	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

}