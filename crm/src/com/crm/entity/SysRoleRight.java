package com.crm.entity;

import java.util.Comparator;

/**
 * SysRoleRight entity. @author MyEclipse Persistence Tools
 */

public class SysRoleRight implements java.io.Serializable,Comparator<SysRoleRight> {

	// Fields

	private Long rfId;
	private SysRight sysRight;
	private SysRole sysRole;
	private String rfUpdateDatetime;

	// Constructors

	/** default constructor */
	public SysRoleRight() {
	}

	/** minimal constructor */
	public SysRoleRight(SysRight sysRight, SysRole sysRole) {
		this.sysRight = sysRight;
		this.sysRole = sysRole;
	}

	/** full constructor */
	public SysRoleRight(SysRight sysRight, SysRole sysRole,
			String rfUpdateDatetime) {
		this.sysRight = sysRight;
		this.sysRole = sysRole;
		this.rfUpdateDatetime = rfUpdateDatetime;
	}

	// Property accessors

	public Long getRfId() {
		return this.rfId;
	}

	public void setRfId(Long rfId) {
		this.rfId = rfId;
	}

	public SysRight getSysRight() {
		return this.sysRight;
	}

	public void setSysRight(SysRight sysRight) {
		this.sysRight = sysRight;
	}

	public SysRole getSysRole() {
		return this.sysRole;
	}

	public void setSysRole(SysRole sysRole) {
		this.sysRole = sysRole;
	}

	public String getRfUpdateDatetime() {
		return this.rfUpdateDatetime;
	}

	public void setRfUpdateDatetime(String rfUpdateDatetime) {
		this.rfUpdateDatetime = rfUpdateDatetime;
	}

	public int compare(SysRoleRight o1, SysRoleRight o2) {
		return o1.getSysRight().getRightCode().compareTo(o2.getSysRight().getRightCode());
	}

}