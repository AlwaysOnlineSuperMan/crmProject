package com.crm.form;

import java.util.HashSet;
import java.util.Set;

import org.apache.struts.action.ActionForm;

/**
 * SysRight entity. @author MyEclipse Persistence Tools
 */

public class SysRightForm extends ActionForm implements java.io.Serializable {

	// Fields

	private String rightCode;
	private String rightParentCode;
	private String rightType;
	private String rightText;
	private String rightUrl;
	private String rightTip;
	private String rightUpdateDatetime;
	private Set sysRoleRights = new HashSet(0);

	

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

	public String getRightType() {
		return this.rightType;
	}

	public void setRightType(String rightType) {
		this.rightType = rightType;
	}

	public String getRightText() {
		return this.rightText;
	}

	public void setRightText(String rightText) {
		this.rightText = rightText;
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

	public String getRightUpdateDatetime() {
		return this.rightUpdateDatetime;
	}

	public void setRightUpdateDatetime(String rightUpdateDatetime) {
		this.rightUpdateDatetime = rightUpdateDatetime;
	}

	public Set getSysRoleRights() {
		return this.sysRoleRights;
	}

	public void setSysRoleRights(Set sysRoleRights) {
		this.sysRoleRights = sysRoleRights;
	}

}