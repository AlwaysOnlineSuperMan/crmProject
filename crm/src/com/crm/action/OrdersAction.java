package com.crm.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.crm.biz.impl.IOrdersService;
import com.crm.dao.impl.IOrdersDAO;
import com.crm.entity.CstLinkman;
import com.crm.entity.Orders;


public class OrdersAction extends DispatchAction implements java.io.Serializable {

	private IOrdersService ordersService;

	public void setOrdersService(IOrdersService ordersService) {
		this.ordersService = ordersService;
	}
	//客户贡献分析   显示客户名字和客户订单的总金额
	public ActionForward nameOrprice(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("1232132132=========");
		List list = ordersService.list();
		request.setAttribute("list", list);
		return mapping.findForward("nameOrprice");
	}
	//客户信息界面点击历史订单进入
	public ActionForward getByName(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {	
		String custNo  =  request.getParameter("custNo");
		String custName  =  request.getParameter("custName");
		request.setAttribute("custNo", custNo);
		request.setAttribute("custName", custName);
		List<Orders> list= ordersService.getByName(custName);
		request.setAttribute("list", list);
		return  mapping.findForward("orderslist");
	}
}