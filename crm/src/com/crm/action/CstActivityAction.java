package com.crm.action;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.crm.biz.impl.ICstActivityService;
import com.crm.biz.impl.ICstCustomerService;
import com.crm.entity.CstActivity;
import com.crm.entity.CstCustomer;
import com.crm.entity.CstLinkman;
import com.crm.form.CstActivityForm;
import com.crm.form.CstLinkmanForm;
import com.sun.org.apache.commons.beanutils.BeanUtils;


public class CstActivityAction  extends DispatchAction implements java.io.Serializable {
	private ICstActivityService cstActivityService;
	
	private ICstCustomerService cstCustomerService;
	

	public ICstCustomerService getCstCustomerService() {
		return cstCustomerService;
	}

	public void setCstCustomerService(ICstCustomerService cstCustomerService) {
		this.cstCustomerService = cstCustomerService;
	}

	public void setCstActivityService(ICstActivityService cstActivityService) {
		this.cstActivityService = cstActivityService;
	}
	
public ICstActivityService getCstActivityService() {
		return cstActivityService;
	}

	//在客户信息显示界面点击交往记录进入
	public ActionForward getByNo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String custNo  =  request.getParameter("custNo");
		System.out.println(custNo);
		CstCustomer cstCustomer = cstCustomerService.getCustNo(custNo);
		request.setAttribute("cstCustomer", cstCustomer);
		request.setAttribute("custNo", custNo);
		List<CstActivity> list= cstActivityService.getByNo(custNo);
		request.setAttribute("list", list);
		return  mapping.findForward("list");
	}
	//进入新建交往记录界面
	public ActionForward New(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String custNo  =  request.getParameter("custNo");
		request.setAttribute("custNo", custNo);
		CstActivityForm activityForm = (CstActivityForm) form;
		activityForm.setAtvDate(new Timestamp(System.currentTimeMillis()));
		return  mapping.findForward("new");
	}
	//添加客户交往记录
	public ActionForward addActivity(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String custNo  =  request.getParameter("custNo");
		CstCustomer cstCustomer = cstCustomerService.getCustNo(custNo);
		CstCustomer cstomer = new CstCustomer();
		cstomer.setCustNo(custNo);
		CstActivityForm activityForm = (CstActivityForm) form;
		CstActivity activityobject = new CstActivity();
		activityobject.setAtvCustName(cstCustomer.getCustName());
		activityobject.setAtvDate(activityForm.getAtvDate());
		activityobject.setAtvDesc(activityForm.getAtvDesc());
		activityobject.setAtvPlace(activityForm.getAtvPlace());
		activityobject.setAtvTitle(activityForm.getAtvTitle());
		activityobject.setAtvUpdateDatetime(new Timestamp(System.currentTimeMillis()));
		activityobject.setCstCustomer(cstomer);
		cstActivityService.saveOrUpd(activityobject);
		return  new ActionForward("/cstActivityAction.do?method=getByNo&custNo="+custNo,true);
	}
	//进入修改交往记录界面
	//在交往记录信息界面中 点击编辑进入  依照此交往记录的ID进行查询 对此交往记录的信息进行编辑
	public ActionForward toedit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {	
		String custNo  =  request.getParameter("custNo");
		request.setAttribute("custNo", custNo);
		Long atvId = Long.valueOf(request.getParameter("atvId"));
		CstActivity cstActivity = cstActivityService.getById(atvId);
		CstActivityForm cstActivityForm = (CstActivityForm) form;
		cstActivityForm.setAtvId(cstActivity.getAtvId());
		cstActivityForm.setAtvCustName(cstActivity.getAtvCustName());
		cstActivityForm.setAtvDate(cstActivity.getAtvDate());
		cstActivityForm.setAtvDesc(cstActivity.getAtvDesc());
		cstActivityForm.setAtvPlace(cstActivity.getAtvPlace());
		cstActivityForm.setAtvTitle(cstActivity.getAtvTitle());
		return  mapping.findForward("edit");
	}
	//依照Id 删除联系人 
	//保存修改的交往记录
	public ActionForward doedit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String custNo  =  request.getParameter("custNo");
		CstCustomer cstCustomer = new CstCustomer();
		cstCustomer.setCustNo(custNo);
		CstActivity cstActivity = new CstActivity();
		CstActivityForm activityForm = (CstActivityForm) form;
		cstActivity.setAtvId(activityForm.getAtvId());
		cstActivity.setAtvCustName(activityForm.getAtvCustName());
		cstActivity.setAtvDate(activityForm.getAtvDate());
		cstActivity.setAtvDesc(activityForm.getAtvDesc());
		cstActivity.setAtvPlace(activityForm.getAtvPlace());
		cstActivity.setAtvTitle(activityForm.getAtvTitle());
		cstActivity.setAtvUpdateDatetime(new Timestamp(System.currentTimeMillis()));
		cstActivity.setCstCustomer(cstCustomer);
		cstActivityService.saveOrUpd(cstActivity);
		return  new ActionForward("/cstActivityAction.do?method=getByNo&custNo="+custNo,true);
	}
	//删除交往记录 
	public ActionForward delById(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {	
		Long atvId = Long.valueOf(request.getParameter("atvId"));
		String custNo = request.getParameter("custNo");
		System.out.println(atvId);
		System.out.println(custNo);
		cstActivityService.delById(atvId);
		return new ActionForward("/cstActivityAction.do?method=getByNo&custNo="+custNo,true);
	}
}