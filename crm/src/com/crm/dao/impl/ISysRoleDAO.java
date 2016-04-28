package com.crm.dao.impl;

import java.util.List;

import com.crm.entity.SysRole;
import com.crm.util.PageModel;

public interface ISysRoleDAO {

	public abstract void save(SysRole transientInstance);

	public abstract void delete(SysRole persistentInstance);

	public abstract SysRole findById(java.lang.Long id);

	public abstract List findByExample(SysRole instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByRoleName(Object roleName);

	public abstract List findByRoleDesc(Object roleDesc);

	public abstract List findByRoleFlag(Object roleFlag);

	public abstract List findByRoleUpdateDatetime(Object roleUpdateDatetime);

	public abstract List findAll();

	public abstract SysRole merge(SysRole detachedInstance);

	public abstract void attachDirty(SysRole instance);

	public abstract void attachClean(SysRole instance);
	public boolean delete(Long roleId);
	public PageModel<SysRole> getPageModel(SysRole sysRole,int page,int pageSize);
}