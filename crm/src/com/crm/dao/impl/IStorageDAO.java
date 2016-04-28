package com.crm.dao.impl;

import java.util.List;

import com.crm.entity.Storage;
import com.crm.util.PageModel;

public interface IStorageDAO {

	public abstract void save(Storage transientInstance);

	public abstract void delete(Storage persistentInstance);

	public abstract Storage findById(java.lang.Long id);

	public abstract List findByExample(Storage instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByStkProdId(Object stkProdId);

	public abstract List findByStkWarehouse(Object stkWarehouse);

	public abstract List findByStkWare(Object stkWare);

	public abstract List findByStkCount(Object stkCount);

	public abstract List findByStkMemo(Object stkMemo);

	public abstract List findAll();

	public abstract Storage merge(Storage detachedInstance);

	public abstract void attachDirty(Storage instance);

	public abstract void attachClean(Storage instance);
	public abstract PageModel<Storage> getPageModel(String[] strs,Storage storage,int page,int pageSize);

}