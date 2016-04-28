package com.crm.biz.impl;

import java.util.List;

import com.crm.entity.Orders;

public interface IOrdersService {
	public abstract List<Orders> list() throws Exception;
	
	public abstract List<Orders> getByName(String custName) throws Exception;
	
	public abstract String[] Select() throws Exception;
	
	public abstract List<Orders> findAll() throws Exception;
	public Orders getByOrderId(Long odr ) throws Exception;
}