package com.hr.entityXX;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Right entity. @author MyEclipse Persistence Tools
 */

public class Right implements java.io.Serializable {

	// Fields

	private String rightCode;
	private String rightParentCode;
	private String rightText;
	private String rightType;
	private String rightUrl;
	private String rightTip;
	private Date updateDateTime;
	private Set roleRights = new HashSet(0);

	// Constructors

	/** default constructor */
	public Right() {
	}

	/** full constructor */
	public Right(String rightParentCode, String rightText, String rightType,
			String rightUrl, String rightTip, Date updateDateTime,
			Set roleRights) {
		this.rightParentCode = rightParentCode;
		this.rightText = rightText;
		this.rightType = rightType;
		this.rightUrl = rightUrl;
		this.rightTip = rightTip;
		this.updateDateTime = updateDateTime;
		this.roleRights = roleRights;
	}

	// Property accessors

	public String getRightCode() {
		return this.rightCode;
	}

	public void setRightCode(String rightCode) {
		this.rightCode = rightCode;
	}

	public String getRightParentCode() {
		return this.rightParentCode;
	}

	public void setRightParentCode(String rightParentCode) {
		this.rightParentCode = rightParentCode;
	}

	public String getRightText() {
		return this.rightText;
	}

	public void setRightText(String rightText) {
		this.rightText = rightText;
	}

	public String getRightType() {
		return this.rightType;
	}

	public void setRightType(String rightType) {
		this.rightType = rightType;
	}

	public String getRightUrl() {
		return this.rightUrl;
	}

	public void setRightUrl(String rightUrl) {
		this.rightUrl = rightUrl;
	}

	public String getRightTip() {
		return this.rightTip;
	}

	public void setRightTip(String rightTip) {
		this.rightTip = rightTip;
	}

	public Date getUpdateDateTime() {
		return this.updateDateTime;
	}

	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	public Set getRoleRights() {
		return this.roleRights;
	}

	public void setRoleRights(Set roleRights) {
		this.roleRights = roleRights;
	}

}