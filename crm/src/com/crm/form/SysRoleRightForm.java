package com.crm.form;

import org.apache.struts.action.ActionForm;

/**
 * SysRoleRight entity. @author MyEclipse Persistence Tools
 */

public class SysRoleRightForm extends ActionForm implements java.io.Serializable {

	// Fields

	private Long rfId;
	private SysRightForm sysRight;
	private SysRoleForm sysRole;
	private String rfUpdateDatetime;

	
	// Property accessors

	public Long getRfId() {
		return this.rfId;
	}

	public void setRfId(Long rfId) {
		this.rfId = rfId;
	}

	public SysRightForm getSysRight() {
		return this.sysRight;
	}

	public void setSysRight(SysRightForm sysRight) {
		this.sysRight = sysRight;
	}

	public SysRoleForm getSysRole() {
		return this.sysRole;
	}

	public void setSysRole(SysRoleForm sysRole) {
		this.sysRole = sysRole;
	}

	public String getRfUpdateDatetime() {
		return this.rfUpdateDatetime;
	}

	public void setRfUpdateDatetime(String rfUpdateDatetime) {
		this.rfUpdateDatetime = rfUpdateDatetime;
	}

}