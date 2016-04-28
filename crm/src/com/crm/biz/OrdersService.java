package com.crm.biz;

import java.util.List;

import com.crm.biz.impl.IOrdersService;
import com.crm.dao.impl.IOrdersDAO;
import com.crm.entity.Orders;


public class OrdersService implements java.io.Serializable, IOrdersService {

	private IOrdersDAO ordersDAO;

	public void setOrdersDAO(IOrdersDAO ordersDAO) {
		this.ordersDAO = ordersDAO;
	}
	public List<Orders> list() throws Exception{
		List<Orders> list = ordersDAO.list();
		return list;
	}
	public List<Orders> getByName(String custName) throws Exception{
		List<Orders> list = ordersDAO.findByName(custName);
		
		return list;
		
	}
	//²éÑ¯È«²¿
	public List<Orders> findAll()throws Exception{
		List<Orders> list = ordersDAO.findAll();
		
		return list;
		
	}
	public Orders getByOrderId(Long odr)throws Exception{
		Orders orders = ordersDAO.findById(odr);
		return orders;
	}
	public String[] Select() throws Exception{
		return ordersDAO.Select();
	}
	
}