package com.crm.biz.impl;

import java.util.List;

import com.crm.entity.SysRole;
import com.crm.util.PageModel;

public interface ISysRoleService {
	public abstract SysRole findByID(Long roleId);
	public abstract List<SysRole> getSysRoleAll();
	public abstract void addRole(SysRole sysRole);
	public abstract void delRole(Long id)throws Exception;
	public PageModel<SysRole> getPageModel(SysRole sysRole,int page,int pageSize)throws Exception;
}