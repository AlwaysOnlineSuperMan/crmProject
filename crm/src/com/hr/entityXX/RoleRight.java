package com.hr.entityXX;

import java.util.Date;

/**
 * RoleRight entity. @author MyEclipse Persistence Tools
 */

public class RoleRight implements java.io.Serializable {

	// Fields

	private Short rfId;
	private Right right;
	private Role role;
	private Date updateDateTime;

	// Constructors

	/** default constructor */
	public RoleRight() {
	}

	/** minimal constructor */
	public RoleRight(Role role) {
		this.role = role;
	}

	/** full constructor */
	public RoleRight(Right right, Role role, Date updateDateTime) {
		this.right = right;
		this.role = role;
		this.updateDateTime = updateDateTime;
	}

	// Property accessors

	public Short getRfId() {
		return this.rfId;
	}

	public void setRfId(Short rfId) {
		this.rfId = rfId;
	}

	public Right getRight() {
		return this.right;
	}

	public void setRight(Right right) {
		this.right = right;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Date getUpdateDateTime() {
		return this.updateDateTime;
	}

	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

}