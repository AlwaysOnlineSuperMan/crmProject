package com.crm.entity;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * SysRole entity. @author MyEclipse Persistence Tools
 */

public class SysRole implements java.io.Serializable {

	// Fields

	private Long roleId;
	private String roleName;
	private String roleDesc;
	private Integer roleFlag;
	private String roleUpdateDatetime;
	private Set sysRoleRights = new TreeSet<SysRoleRight>();

	// Constructors

	/** default constructor */
	public SysRole() {
	}

	/** minimal constructor */
	public SysRole(String roleName) {
		this.roleName = roleName;
	}

	/** full constructor */
	public SysRole(String roleName, String roleDesc, Integer roleFlag,
			String roleUpdateDatetime, Set sysRoleRights) {
		this.roleName = roleName;
		this.roleDesc = roleDesc;
		this.roleFlag = roleFlag;
		this.roleUpdateDatetime = roleUpdateDatetime;
		this.sysRoleRights = sysRoleRights;
	}

	// Property accessors

	public Long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return this.roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public Integer getRoleFlag() {
		return this.roleFlag;
	}

	public void setRoleFlag(Integer roleFlag) {
		this.roleFlag = roleFlag;
	}

	public String getRoleUpdateDatetime() {
		return this.roleUpdateDatetime;
	}

	public void setRoleUpdateDatetime(String roleUpdateDatetime) {
		this.roleUpdateDatetime = roleUpdateDatetime;
	}

	public Set getSysRoleRights() {
		return this.sysRoleRights;
	}

	public void setSysRoleRights(Set sysRoleRights) {
		this.sysRoleRights = sysRoleRights;
	}

	@Override
	public String toString() {
		return "SysRole [roleDesc=" + roleDesc + ", roleFlag=" + roleFlag
				+ ", roleId=" + roleId + ", roleName=" + roleName
				+ ", roleUpdateDatetime=" + roleUpdateDatetime
				+ ", sysRoleRights=" + sysRoleRights + "]";
	}

}