package com.crm.biz.impl;

import java.util.List;

import com.crm.entity.OrdersLine;

public interface IOrdersLineService {
	//依照订单编号查找到此条订单详情
	public abstract List<OrdersLine> getOrderId(Long orderId)throws Exception;
}