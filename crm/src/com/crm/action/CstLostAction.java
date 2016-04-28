package com.crm.action;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.crm.biz.impl.ICstCustomerService;
import com.crm.biz.impl.ICstLostService;
import com.crm.dao.impl.ICstLostDAO;
import com.crm.entity.CstCustomer;
import com.crm.entity.CstLost;
import com.crm.form.CstLostForm;



public class CstLostAction extends DispatchAction implements java.io.Serializable {
	private ICstLostService cstLostService;
	
	private ICstCustomerService cstCustomerService;
	
	
	

	public ICstCustomerService getCstCustomerService() {
		return cstCustomerService;
	}

	public void setCstCustomerService(ICstCustomerService cstCustomerService) {
		this.cstCustomerService = cstCustomerService;
	}

	public ICstLostService getCstLostService() {
		return cstLostService;
	}

	public void setCstLostService(ICstLostService cstLostService) {
		this.cstLostService = cstLostService;
	} 
	
	public ActionForward toLostList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CstLostForm cstLostForm = (CstLostForm) form;
		List<CstLost> cstLostObjectList = cstLostService.getCstLostAll();
		//cstLostForm.setCstLostObjectList(cstLostObjectList);
		request.setAttribute("cstLostObjectList", cstLostObjectList);
		return mapping.findForward("toLost");
	}
//加载流失的客户 
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<CstLost> list = cstLostService.getCstLostAll();
		String custNo = list.get(0).getCstCustomer().getCustNo();
		CstCustomer cstCustomer = cstCustomerService.getCustNo(custNo);
		Long id = new Long(19);
		CstCustomer cstcustomer = cstCustomerService.getCstCustomerId(id);
		request.setAttribute("cust", cstcustomer);
		request.setAttribute("customer", cstCustomer);
		request.setAttribute("list", list);
		return mapping.findForward("list");
	}
	//暂缓流失
	public ActionForward relay(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String custNo = request.getParameter("custNo");
		Long lstId = Long.valueOf(request.getParameter("lstId"));
		
		CstCustomer cstCustomer = cstCustomerService.getCustNo(custNo);
		CstLost cstLost = cstLostService.getById(lstId );
		System.out.println(cstCustomer.getCustName());
		CstLostForm cstLostForm = (CstLostForm) form;
		cstLostForm.setLstId(cstLost.getLstId());
		cstLostForm.setLstCustName(cstCustomer.getCustName());
		cstLostForm.setLstCustManagerId(cstCustomer.getCustManagerId());
		cstLostForm.setLstCustManagerName(cstCustomer.getCustManagerName());
		cstLostForm.setLstLastOrderDate(cstLost.getLstLastOrderDate());
		cstLostForm.setLstLostDate(cstLost.getLstLostDate());
		cstLostForm.setLstReason(cstLost.getLstReason());
		cstLostForm.setLstStatus(cstLost.getLstStatus());
		request.setAttribute("cstcust", cstCustomer);
		request.setAttribute("cstLost", cstLost);
		return mapping.findForward("relay");
	}
	//对暂缓流失的客户进行保存
	public ActionForward dorelay(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		CstLostForm cstLostForm = (CstLostForm) form;
		String id ="2";
		cstLostForm.setLstStatus(id);
		CstLost cstLost = new CstLost();
		cstLost.setLstId(cstLostForm.getLstId());
		cstLost.setLstCustName(cstLostForm.getLstCustName());
		cstLost.setLstCustManagerId(cstLostForm.getLstCustManagerId());
		cstLost.setLstCustManagerName(cstLostForm.getLstCustManagerName());
		cstLost.setLstDelay(cstLostForm.getLstDelay());
		cstLost.setLstLastOrderDate(cstLostForm.getLstLastOrderDate());
		cstLost.setLstLostDate(cstLostForm.getLstLostDate());
		cstLost.setLstReason(cstLostForm.getLstReason());
		cstLost.setLstStatus(cstLostForm.getLstStatus());
		cstLost.setLstUpdateDatetime(new Timestamp(System.currentTimeMillis()));
		cstLostService.saveOrUpdate(cstLost);
		return new ActionForward("/cstLostAction.do?method=list");
	}
	
	//确认流失
	public ActionForward confirm(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String custNo = request.getParameter("custNo");
		Long lstId = Long.valueOf(request.getParameter("lstId"));
		
		CstCustomer cstCustomer = cstCustomerService.getCustNo(custNo);
		CstLost cstLost = cstLostService.getById(lstId );
		System.out.println(cstCustomer.getCustName());
		CstLostForm cstLostForm = (CstLostForm) form;
		cstLostForm.setLstId(cstLost.getLstId());
		cstLostForm.setLstCustName(cstCustomer.getCustName());
		cstLostForm.setLstCustManagerId(cstCustomer.getCustManagerId());
		cstLostForm.setLstCustManagerName(cstCustomer.getCustManagerName());
		cstLostForm.setLstLastOrderDate(cstLost.getLstLastOrderDate());
		cstLostForm.setLstLostDate(cstLost.getLstLostDate());
		cstLostForm.setLstReason(cstLost.getLstReason());
		cstLostForm.setLstStatus(cstLost.getLstStatus());
		request.setAttribute("cstcust", cstCustomer);
		request.setAttribute("cstLost", cstLost);

		return mapping.findForward("confirm");
	}
	//对确认流失的客户进行保存
	public ActionForward doconfirm(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		CstLostForm cstLostForm = (CstLostForm) form;
		String id ="3";
		cstLostForm.setLstStatus(id);
		CstLost cstLost = new CstLost();
		cstLost.setLstId(cstLostForm.getLstId());
		cstLost.setLstCustName(cstLostForm.getLstCustName());
		cstLost.setLstCustManagerId(cstLostForm.getLstCustManagerId());
		cstLost.setLstCustManagerName(cstLostForm.getLstCustManagerName());
		cstLost.setLstDelay(cstLostForm.getLstDelay());
		cstLost.setLstLastOrderDate(cstLostForm.getLstLastOrderDate());
		cstLost.setLstLostDate(cstLostForm.getLstLostDate());
		cstLost.setLstReason(cstLostForm.getLstReason());
		cstLost.setLstStatus(cstLostForm.getLstStatus());
		cstLost.setLstUpdateDatetime(new Timestamp(System.currentTimeMillis()));
		cstLostService.saveOrUpdate(cstLost);
		return new ActionForward("/cstLostAction.do?method=list");
	}
}