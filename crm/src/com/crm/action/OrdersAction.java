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
	//�ͻ����׷���   ��ʾ�ͻ����ֺͿͻ��������ܽ��
	public ActionForward nameOrprice(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("1232132132=========");
		List list = ordersService.list();
		request.setAttribute("list", list);
		return mapping.findForward("nameOrprice");
	}
	//�ͻ���Ϣ��������ʷ��������
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