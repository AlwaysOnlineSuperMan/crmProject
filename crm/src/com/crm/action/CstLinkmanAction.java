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

		//�ڿͻ���Ϣ��ʾ��������ϵ�˽������տͻ���Ų�ѯ�˿ͻ���������ϵ�� 
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
		//����ϵ����Ϣ������ ����༭����  ���մ���ϵ�˵�ID���в�ѯ �Դ���ϵ�˵���Ϣ���б༭
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
		//�����½���ϵ�˽��� 
		public ActionForward New(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {	
			String custNo  =  request.getParameter("custNo");
			String custName  =  request.getParameter("custName");
			request.setAttribute("custNo", custNo);
			request.setAttribute("custName", custName);
			return  mapping.findForward("new");
		}
		//�½���ϵ��
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
		//�޸���ϵ����Ϣ
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
			
			System.out.println("�޸ĺ�:"+cstlinkmanobject.toString());
			
			cstLinkmanService.Update(cstlinkmanobject);
			
			return  new ActionForward("/cstLinkmanAction.do?method=getByNo&custName="+custName+"&custNo="+custNo,true);
		}
		//����Id ɾ����ϵ�� 
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