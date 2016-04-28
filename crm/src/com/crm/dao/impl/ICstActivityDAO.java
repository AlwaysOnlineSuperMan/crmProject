package com.crm.dao.impl;

import java.util.List;

import com.crm.entity.CstActivity;
import com.crm.entity.CstLinkman;

public interface ICstActivityDAO {

	public abstract void save(CstActivity transientInstance);

	public abstract void delete(CstActivity persistentInstance);
	public abstract boolean delById(Long lkmId);

	public abstract CstActivity findById(java.lang.Long id);
	
	public abstract void saveOrUpdate(CstActivity transientInstance);
	
	public abstract List<CstActivity> findByNo(String custNo);

	public abstract List findByExample(CstActivity instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByAtvCustName(Object atvCustName);

	public abstract List findByAtvPlace(Object atvPlace);

	public abstract List findByAtvTitle(Object atvTitle);

	public abstract List findByAtvDesc(Object atvDesc);

	public abstract List findAll();

	public abstract CstActivity merge(CstActivity detachedInstance);

	public abstract void attachDirty(CstActivity instance);

	public abstract void attachClean(CstActivity instance);

}