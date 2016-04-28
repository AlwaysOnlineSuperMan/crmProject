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
import com.crm.biz.impl.ICstLinkmanService;
import com.crm.dao.impl.ICstLinkmanDAO;
import com.crm.entity.CstCustomer;
import com.crm.entity.CstLinkman;
import com.crm.form.CstCustomerForm;
import com.crm.form.CstLinkmanForm;
import com.sun.org.apache.commons.beanutils.BeanUtils;



public class CstLinkmanAction extends DispatchAction implements java.io.Serializable {
   private	ICstLinkmanService cstLinkmanService;
   private ICstCustomerService cstCustomerService;

   
public ICstCustomerService getCstCustomerService() {
	return cstCustomerService;
}

public void setCstCustomerService(ICstCustomerService cstCustomerService) {
	this.cstCustomerService = cstCustomerService;
}

public void setCstLinkmanService(ICstLinkmanService cstLinkmanService) {
	this.cstLinkmanService = cstLinkmanService;
}

public ICstLinkmanService getCstLinkmanService() {
	return cstLinkmanService;
}

		//在客户信息显示界面点击联系人进入依照客户编号查询此客户的所有联系人 
		public ActionForward getByNo(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {	
			String custNo  =  request.getParameter("custNo");
			List<CstLinkman> list= cstLinkmanService.getByNo(custNo);
			CstCustomer customer = cstCustomerService.getCustNo(custNo);
			request.setAttribute("custNo", custNo);
			request.setAttribute("linkman", customer);
			System.out.println(customer.toString());
			
			request.setAttribute("list", list);
			return  mapping.findForward("list");
		}
		//在联系人信息界面中 点击编辑进入  依照此联系人的ID进行查询 对此联系人的信息进行编辑
		public ActionForward getById(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {	
			Long lkId  =  Long.valueOf(request.getParameter("lkId"));
			String custNo  =  request.getParameter("custNo");
			request.setAttribute("custNo", custNo);
			CstLinkmanForm cstLinkmanForm = (CstLinkmanForm) form;
			
			CstLinkman linkman = cstLinkmanService.getById(lkId);
			
			
			request.setAttribute("linkman", linkman);
			
			return  mapping.findForward("edit");
		}
		//跳到新建联系人界面 
		public ActionForward New(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {	
			String custNo  =  request.getParameter("custNo");
			String custName  =  request.getParameter("custName");
			request.setAttribute("custNo", custNo);
			request.setAttribute("custName", custName);
			return  mapping.findForward("new");
		}
		//新建联系人
		public ActionForward addLinkman(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
		
			CstLinkmanForm cstLinkmanform = (CstLinkmanForm) form;
			String custNo = request.getParameter("custNo");
			CstCustomer customer = cstCustomerService.getCustNo(custNo);
		
			request.setAttribute("linkman", customer);
			request.setAttribute("custNo", custNo);
			
			CstCustomer cstcustomer = new CstCustomer();
			cstcustomer.setCustNo(custNo);
			CstLinkman cstlinkmanobject = new CstLinkman();
			cstlinkmanobject.setCstCustomer(cstcustomer);
			cstlinkmanobject.setLkmCustName(customer.getCustName());
			cstlinkmanobject.setLkmName(cstLinkmanform.getLkmName());
			cstlinkmanobject.setLkmSex(cstLinkmanform.getLkmSex());
			cstlinkmanobject.setLkmPostion(cstLinkmanform.getLkmPostion());
			cstlinkmanobject.setLkmTel(cstLinkmanform.getLkmTel());
			cstlinkmanobject.setLkmMemo(cstLinkmanform.getLkmMemo());
			cstlinkmanobject.setLkmMobile(cstLinkmanform.getLkmMobile());
			cstlinkmanobject.setLkmUpdateDatetime(new Timestamp(System.currentTimeMillis()));
			cstLinkmanService.saveOrUpd(cstlinkmanobject);
			
			return  new ActionForward("/cstLinkmanAction.do?method=getByNo&custNo="+custNo,true);
		}
		//修改联系人信息
		public ActionForward updLinkman(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			
			
			
			String custNo = request.getParameter("custNo");
			String custName = request.getParameter("custName");
			CstCustomer cstcustomer = new CstCustomer();
			cstcustomer.setCustNo(custNo);
			CstLinkmanForm cstLinkmanform = (CstLinkmanForm) form;
			CstCustomer customer = cstCustomerService.getCustNo(custNo);
			
			request.setAttribute("linkman", customer);
			
			CstLinkman cstlinkmanobject = new CstLinkman();
			cstlinkmanobject.setCstCustomer(cstcustomer);
			cstlinkmanobject.setLkmId(cstLinkmanform.getLkmId());
			cstlinkmanobject.setLkmCustName(cstLinkmanform.getLkmCustName());
			cstlinkmanobject.setLkmName(cstLinkmanform.getLkmName());
			cstlinkmanobject.setLkmSex(cstLinkmanform.getLkmSex());
			cstlinkmanobject.setLkmPostion(cstLinkmanform.getLkmPostion());
			cstlinkmanobject.setLkmTel(cstLinkmanform.getLkmTel());
			cstlinkmanobject.setLkmMemo(cstLinkmanform.getLkmMemo());
			cstlinkmanobject.setLkmMobile(cstLinkmanform.getLkmMobile());
			cstlinkmanobject.setLkmUpdateDatetime(new Timestamp(System.currentTimeMillis()));
			
			System.out.println("修改后:"+cstlinkmanobject.toString());
			
			cstLinkmanService.Update(cstlinkmanobject);
			
			return  new ActionForward("/cstLinkmanAction.do?method=getByNo&custName="+custName+"&custNo="+custNo,true);
		}
		//依照Id 删除联系人 
		public ActionForward delById(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {	
			Long lkId = Long.valueOf(request.getParameter("lkmId"));
			String custName = request.getParameter("custName");
			String custNo = request.getParameter("custNo");
			System.out.println(lkId);
			cstLinkmanService.delById(lkId);
			return new ActionForward("/cstLinkmanAction.do?method=getByNo&custName="+custName+"&custNo="+custNo,true);
		}
}