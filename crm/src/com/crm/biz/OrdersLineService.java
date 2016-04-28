package com.crm.biz;

import java.util.List;

import com.crm.biz.impl.IOrdersLineService;
import com.crm.dao.impl.IOrdersLineDAO;
import com.crm.entity.OrdersLine;
 
public class OrdersLineService implements java.io.Serializable, IOrdersLineService {

	private IOrdersLineDAO ordersLineDAO;

	public void setOrdersLineDAO(IOrdersLineDAO ordersLineDAO) {
		this.ordersLineDAO = ordersLineDAO;
	}
	//依照订单编号查找到此条订单详情
	public List<OrdersLine> getOrderId(Long orderId)throws Exception{
		List<OrdersLine> ordersline = ordersLineDAO.findByOddOrderId(orderId);
		return ordersline;
	}

}