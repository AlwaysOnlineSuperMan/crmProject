package com.crm.form;

import java.util.HashSet;
import java.util.Set;

import org.apache.struts.action.ActionForm;

import com.crm.entity.SysRole;
import com.crm.entity.SysUser;
import com.crm.util.PageModel;

/**
 * SysRole entity. @author MyEclipse Persistence Tools
 */

public class SysRoleForm extends ActionForm implements java.io.Serializable {

	// Fields

	private Long roleId;
	private String roleName;
	private String roleDesc;
	private Integer roleFlag;
	private String roleUpdateDatetime;
	private Set sysRoleRights = new HashSet(0);
	
	
	private PageModel<SysRole> pageModel = new PageModel<SysRole>();

	// Property accessors

	public PageModel<SysRole> getPageModel() {
		return pageModel;
	}

	public void setPageModel(PageModel<SysRole> pageModel) {
		this.pageModel = pageModel;
	}

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

}