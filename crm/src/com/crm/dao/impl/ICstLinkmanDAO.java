package com.crm.dao.impl;

import java.util.List;

import com.crm.entity.CstLinkman;

public interface ICstLinkmanDAO {

	public abstract void save(CstLinkman transientInstance);
	
	public abstract void saveOrUpdate(CstLinkman transientInstance);
	
	public abstract void update(CstLinkman transientInstance);

	public abstract void delete(CstLinkman persistentInstance);

	public abstract CstLinkman findById(java.lang.Long id);
	
	public abstract List<CstLinkman> findByNo(String custNo);

	public abstract boolean delById(Long lkmId);
	
	public abstract List findByExample(CstLinkman instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByLkmCustName(Object lkmCustName);

	public abstract List findByLkmName(Object lkmName);

	public abstract List findByLkmSex(Object lkmSex);

	public abstract List findByLkmPostion(Object lkmPostion);

	public abstract List findByLkmTel(Object lkmTel);

	public abstract List findByLkmMobile(Object lkmMobile);

	public abstract List findByLkmMemo(Object lkmMemo);

	public abstract List findAll();

	public abstract CstLinkman merge(CstLinkman detachedInstance);

	public abstract void attachDirty(CstLinkman instance);

	public abstract void attachClean(CstLinkman instance);

}