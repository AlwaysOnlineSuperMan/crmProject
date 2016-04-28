package com.crm.dao.impl;

import java.util.List;

import com.crm.entity.Orders;

public interface IOrdersDAO {

	public abstract void save(Orders transientInstance);

	public abstract void delete(Orders persistentInstance);

	public abstract Orders findById(Long odr);
	
	public abstract List<Orders> findByName(String custName);

	public abstract List findByExample(Orders instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByOdrCustomer(Object odrCustomer);

	public abstract List findByOdrAddr(Object odrAddr);

	public abstract List findByOdrStatus(Object odrStatus);

	public abstract List findAll();

	public abstract Orders merge(Orders detachedInstance);

	public abstract void attachDirty(Orders instance);

	public abstract void attachClean(Orders instance);
	public abstract List list();
	public abstract String[] Select(); 
}