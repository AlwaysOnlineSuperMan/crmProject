package com.hr.entityXX;

import java.util.Date;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class Users implements java.io.Serializable {

	// Fields

	private Short UId;
	private Role role;
	private String UName;
	private String UTrueName;
	private String UPassword;
	private Date updateDateTime;

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** full constructor */
	public Users(Role role, String UName, String UTrueName, String UPassword,
			Date updateDateTime) {
		this.role = role;
		this.UName = UName;
		this.UTrueName = UTrueName;
		this.UPassword = UPassword;
		this.updateDateTime = updateDateTime;
	}

	// Property accessors

	public Short getUId() {
		return this.UId;
	}

	public void setUId(Short UId) {
		this.UId = UId;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getUName() {
		return this.UName;
	}

	public void setUName(String UName) {
		this.UName = UName;
	}

	public String getUTrueName() {
		return this.UTrueName;
	}

	public void setUTrueName(String UTrueName) {
		this.UTrueName = UTrueName;
	}

	public String getUPassword() {
		return this.UPassword;
	}

	public void setUPassword(String UPassword) {
		this.UPassword = UPassword;
	}

	public Date getUpdateDateTime() {
		return this.updateDateTime;
	}

	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

}