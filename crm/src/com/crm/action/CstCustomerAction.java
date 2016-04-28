package com.crm.action;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.crm.biz.CstCustomerService;
import com.crm.biz.impl.IBasDictService;
import com.crm.biz.impl.ICstCustomerService;
import com.crm.biz.impl.ISalChanceService;
import com.crm.biz.impl.ISysUserService;
import com.crm.dao.impl.ICstCustomerDAO;
import com.crm.entity.BasDict;
import com.crm.entity.CstCustomer;
import com.crm.entity.SalChance;
import com.crm.entity.SysUser;
import com.crm.form.CstCustomerForm;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class CstCustomerAction  extends DispatchAction implements java.io.Serializable {
	ICstCustomerService cstCustomerService;
	ISalChanceService salChanceService; 
	IBasDictService basDictService;
	ISysUserService sysUserService;

	public void setSalChanceService(ISalChanceService salChanceService) {
		this.salChanceService = salChanceService;
	}

	public void setCstCustomerService(ICstCustomerService cstCustomerService) {
		this.cstCustomerService = cstCustomerService;
	}
	
	public ICstCustomerService getCstCustomerService() {
		return cstCustomerService;
	}
	
	
	public IBasDictService getBasDictService() {
		return basDictService;
	}

	public void setBasDictService(IBasDictService basDictService) {
		this.basDictService = basDictService;
	}
	
	public ISysUserService getSysUserService() {
		return sysUserService;
	}

	public void setSysUserService(ISysUserService sysUserService) {
		this.sysUserService = sysUserService;
	}

	public ISalChanceService getSalChanceService() {
		return salChanceService;
	}
	//单条查询
	public ActionForward One(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CstCustomerForm cstcustomerform = (CstCustomerForm) form;
		String name = "海天";
		
		List<CstCustomer> list = cstCustomerService.getcstcustName(name);
		
		String type="客户等级";
		List<BasDict> KH = basDictService.getByType(type);
		String type1="地区";
		List<BasDict> address = basDictService.getByType(type1);
		
		
		cstcustomerform.setDictList(address);
		cstcustomerform.setBasdictList(KH);
//		return new ActionFordelByNoward("xx.do?met=ddd");
		request.setAttribute("list", list);
		System.out.println(list.size());
		return mapping.findForward("all");
	}
	//页面初始化，加载当前用户的客户
	public ActionForward listAll(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CstCustomerForm cstcustomerform = (CstCustomerForm) form;
		
		String type="客户等级";
		List<BasDict> KH = basDictService.getByType(type);
		String type1="地区";
		List<BasDict> address = basDictService.getByType(type1);
		
		
		cstcustomerform.setDictList(address);
		cstcustomerform.setBasdictList(KH);
		List<CstCustomer> list = cstCustomerService.getCstCustomerList();
//		return new ActionFordelByNoward("xx.do?met=ddd");
		request.setAttribute("list", list);
		
		return mapping.findForward("all");
	}
	//依照客户编号，删除客户
	public ActionForward delByNo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("======");
		String custNo = request.getParameter("custNo");
		System.out.println("123214");
		cstCustomerService.delByNo(custNo);
		System.out.println(custNo);
		return new ActionForward("/cstCustomerAction.do?method=listAll",true);
	}
	//编辑客户信息，依靠客户编号进入客户信息页面edit.jsp
	public ActionForward updByno(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CstCustomerForm cstCustomerForm = (CstCustomerForm) form;
		String custNo  =  request.getParameter("custNo");
		
		String type="客户等级";
		List<BasDict> KH = basDictService.getByType(type);
		String type1="地区";
		List<BasDict> address = basDictService.getByType(type1);
		cstCustomerForm.setDictList(address);
		cstCustomerForm.setBasdictList(KH);
		List<SysUser> sysUserList= sysUserService.getSysUserObjectList();
		cstCustomerForm.setSysuserList(sysUserList);
		CstCustomer cstsustomer = cstCustomerService.getCustNo(custNo);
		BeanUtils.copyProperties(cstCustomerForm, cstsustomer);
	
		return  mapping.findForward("edit");
	}
	public ActionForward getdBytext(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("===============");
		
		return  mapping.findForward("edit");
	}
	
	//保存修改的客户信息
	public ActionForward doUpdByno(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CstCustomerForm cstCustomerForm = (CstCustomerForm) form;
		CstCustomer cstcustomerObject = new CstCustomer();
		cstcustomerObject.setCustNo(cstCustomerForm.getCustNo());
		cstcustomerObject.setCustName(cstCustomerForm.getCustName());
		cstcustomerObject.setCustRegion(cstCustomerForm.getCustRegion());
		cstcustomerObject.setCustManagerId(cstCustomerForm.getCustManagerId());
		cstcustomerObject.setCustManagerName(cstCustomerForm.getCustManagerName());
		cstcustomerObject.setCustLevel(cstCustomerForm.getCustLevel());
		cstcustomerObject.setCustLevelLabel(cstCustomerForm.getCustLevelLabel());
		cstcustomerObject.setCustSatisfy(cstCustomerForm.getCustSatisfy());
		cstcustomerObject.setCustCredit(cstCustomerForm.getCustCredit());
		cstcustomerObject.setCustAddr(cstCustomerForm.getCustAddr());
		cstcustomerObject.setCustZip(cstCustomerForm.getCustZip());
		cstcustomerObject.setCustTel(cstCustomerForm.getCustTel());
		cstcustomerObject.setCustFax(cstCustomerForm.getCustFax());
		cstcustomerObject.setCustWebsite(cstCustomerForm.getCustWebsite());
		cstcustomerObject.setCustLicenceNo(cstCustomerForm.getCustLicenceNo());
		cstcustomerObject.setCustChieftain(cstCustomerForm.getCustChieftain());
		cstcustomerObject.setCustBankroll(cstCustomerForm.getCustBankroll());
		cstcustomerObject.setCustTurnover(cstCustomerForm.getCustTurnover());
		cstcustomerObject.setCustBank(cstCustomerForm.getCustBank());
		cstcustomerObject.setCustBankAccount(cstCustomerForm.getCustBankAccount());
		cstcustomerObject.setCustLocalTaxNo(cstCustomerForm.getCustLocalTaxNo());
		cstcustomerObject.setCustNationalTaxNo(cstCustomerForm.getCustNationalTaxNo());
		
		cstcustomerObject.setCustUpdateDatetime(new Timestamp(System.currentTimeMillis()));
		cstcustomerObject.setCustStatus(cstCustomerForm.getCustStatus());
		cstCustomerService.saveOrUpdate(cstcustomerObject);
		
		
		return new ActionForward("/cstCustomerAction.do?method=listAll",true);
	}
	//添加客户
	public ActionForward addCustomer(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Long chcId =Long.valueOf(request.getParameter("chcId"));
		SalChance salChance = salChanceService.getSalChanceByID(chcId);
		CstCustomer cstCustomer = new CstCustomer();
		cstCustomer.setCustNo("KH201412050001");
		cstCustomer.setCustName(salChance.getChcCustName());
		cstCustomer.setCustManagerId(salChance.getChcDueId());
		cstCustomer.setCustManagerName(salChance.getChcDueTo());
		cstCustomer.setCustLevel(1);
		cstCustomer.setCustLevelLabel("普通客户");
		cstCustomer.setCustStatus("1");
		cstCustomer.setCustUpdateDatetime(new Timestamp(System.currentTimeMillis()));
		cstCustomerService.addCustomer(cstCustomer);
		
		//改变状态
		SalChance salChanceObject = new SalChance();
		salChanceObject.setChcId(chcId);
		salChanceService.successSalChance(salChanceObject);
		
		System.out.println("chcId"+chcId);
		return new ActionForward("/salPlanAction.do?method=planList");
	}
	
}