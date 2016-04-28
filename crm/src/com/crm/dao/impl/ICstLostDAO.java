package com.crm.dao.impl;

import java.util.List;

import com.crm.entity.CstLinkman;
import com.crm.entity.CstLost;

public interface ICstLostDAO {

	public abstract void save(CstLost transientInstance);

	public abstract void saveOrUpdate(CstLost transientInstance);
	public abstract void delete(CstLost persistentInstance);

	public abstract CstLost findById(java.lang.Long id);

	public abstract List findByExample(CstLost instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByLstCustName(Object lstCustName);

	public abstract List findByLstCustManagerId(Object lstCustManagerId);

	public abstract List findByLstCustManagerName(Object lstCustManagerName);

	public abstract List findByLstDelay(Object lstDelay);

	public abstract List findByLstReason(Object lstReason);

	public abstract List findByLstStatus(Object lstStatus);

	public abstract List findAll();

	public abstract CstLost merge(CstLost detachedInstance);

	public abstract void attachDirty(CstLost instance);

	public abstract void attachClean(CstLost instance);

}