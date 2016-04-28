package com.hr.entityXX;

import java.util.Date;

/**
 * ConfigMajorDesignation entity. @author MyEclipse Persistence Tools
 */

public class ConfigMajorDesignation implements java.io.Serializable {

	// Fields

	private Short cmdId;
	private String cmdName;
	private Date updateDateTime;

	// Constructors

	/** default constructor */
	public ConfigMajorDesignation() {
	}

	/** full constructor */
	public ConfigMajorDesignation(String cmdName, Date updateDateTime) {
		this.cmdName = cmdName;
		this.updateDateTime = updateDateTime;
	}

	// Property accessors

	public Short getCmdId() {
		return this.cmdId;
	}

	public void setCmdId(Short cmdId) {
		this.cmdId = cmdId;
	}

	public String getCmdName() {
		return this.cmdName;
	}

	public void setCmdName(String cmdName) {
		this.cmdName = cmdName;
	}

	public Date getUpdateDateTime() {
		return this.updateDateTime;
	}

	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

}