package com.crm.biz.impl;

import java.util.List;

import com.crm.entity.OrdersLine;

public interface IOrdersLineService {
	//���ն�����Ų��ҵ�������������
	public abstract List<OrdersLine> getOrderId(Long orderId)throws Exception;
}