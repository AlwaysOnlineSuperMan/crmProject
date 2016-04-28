package com.crm.dao.impl;

import java.util.List;

import com.crm.entity.SysRoleRight;

public interface ISysRoleRightDAO {

	public abstract void save(SysRoleRight transientInstance);

	public abstract void delete(SysRoleRight persistentInstance);

	public abstract SysRoleRight findById(java.lang.Long id);

	public abstract List findByExample(SysRoleRight instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByRfUpdateDatetime(Object rfUpdateDatetime);

	public abstract List findAll();

	public abstract SysRoleRight merge(SysRoleRight detachedInstance);

	public abstract void attachDirty(SysRoleRight instance);

	public abstract void attachClean(SysRoleRight instance);

}