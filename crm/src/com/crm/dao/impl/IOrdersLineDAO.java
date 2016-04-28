package com.crm.dao.impl;

import java.util.List;

import com.crm.entity.OrdersLine;

public interface IOrdersLineDAO {

	public abstract void save(OrdersLine transientInstance);

	public abstract void delete(OrdersLine persistentInstance);

	public abstract List findByExample(OrdersLine instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByOddOrderId(Object oddOrderId);

	public abstract List findByOddProdId(Object oddProdId);

	public abstract List findByOddCount(Object oddCount);

	public abstract List findByOddUnit(Object oddUnit);

	public abstract List findByOddPrice(Object oddPrice);

	public abstract List findAll();

	public abstract OrdersLine merge(OrdersLine detachedInstance);

	public abstract void attachDirty(OrdersLine instance);

	public abstract void attachClean(OrdersLine instance);

}