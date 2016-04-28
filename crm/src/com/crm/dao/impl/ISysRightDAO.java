package com.crm.dao.impl;

import java.util.List;

import com.crm.entity.SysRight;

public interface ISysRightDAO {

	public abstract void save(SysRight transientInstance);

	public abstract void delete(SysRight persistentInstance);

	public abstract SysRight findById(java.lang.String id);

	public abstract List findByExample(SysRight instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByRightParentCode(Object rightParentCode);

	public abstract List findByRightType(Object rightType);

	public abstract List findByRightText(Object rightText);

	public abstract List findByRightUrl(Object rightUrl);

	public abstract List findByRightTip(Object rightTip);

	public abstract List findByRightUpdateDatetime(Object rightUpdateDatetime);

	public abstract List findAll();

	public abstract SysRight merge(SysRight detachedInstance);

	public abstract void attachDirty(SysRight instance);

	public abstract void attachClean(SysRight instance);

}