package com.crm.action;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.crm.biz.impl.ISalChanceService;
import com.crm.biz.impl.ISalPlanService;
import com.crm.dao.impl.ISalPlanDAO;
import com.crm.entity.SalChance;
import com.crm.entity.SalPlan;
import com.crm.form.SalChanceForm;
import com.crm.form.SalPlanForm;
import com.crm.view.LoginView;


public class SalPlanAction extends DispatchAction implements java.io.Serializable {
	private ISalPlanService salPlanService;
	private ISalChanceService salChanceService;
	public void setSalChanceService(ISalChanceService salChanceService) {
		this.salChanceService = salChanceService;
	}
	public void setSalPlanService(ISalPlanService salPlanService) {
		this.salPlanService = salPlanService;
	}
	public ActionForward dev_detail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 SalPlanForm salPlanForm = (SalPlanForm)form;
		 SalChanceForm salChanceForm = new SalChanceForm();
		 Long  chcId = Long.valueOf(request.getParameter("chcId"));
		 List<SalPlan> salPlanList = salPlanService.getSalPlanByID(chcId);
		 salPlanForm.setSalPlanList(salPlanList);
		 SalChance salChance = salChanceService.getSalChanceByID(chcId);
		 System.out.println(salChance.getChcStatus());
		 BeanUtils.copyProperties(salChanceForm, salChance);
		 salPlanForm.setSalChance(salChanceForm);
		request.setAttribute("salPlanList",salPlanList);
		return mapping.findForward("dev_detail");
	}
	public ActionForward toDev_plan(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 SalPlanForm salPlanForm = (SalPlanForm)form;
		 SalChanceForm salChanceForm = new SalChanceForm();
		 Long  chcId = Long.valueOf(request.getParameter("chcId"));
		 List<SalPlan> salPlanList = salPlanService.getSalPlanByID(chcId);
		 salPlanForm.setSalPlanList(salPlanList);
		 SalChance salChance = salChanceService.getSalChanceByID(chcId);
		 salPlanForm.setSalChance(salChanceForm);
		 salPlanForm.setPlaDate(new Timestamp(System.currentTimeMillis()));
		 BeanUtils.copyProperties(salChanceForm, salChance);
		
		request.setAttribute("salPlanList",salPlanList);
		return mapping.findForward("dev_plan");
	}
	public ActionForward toDev_execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 SalPlanForm salPlanForm = (SalPlanForm)form;
		 SalChanceForm salChanceForm = new SalChanceForm();
		 Long  chcId = Long.valueOf(request.getParameter("chcId"));
		 List<SalPlan> salPlanList = salPlanService.getSalPlanByID(chcId);
		 salPlanForm.setSalPlanList(salPlanList);
		 SalChance salChance = salChanceService.getSalChanceByID(chcId);
		 BeanUtils.copyProperties(salChanceForm, salChance);
		 salPlanForm.setSalChance(salChanceForm);
		request.setAttribute("salPlanList",salPlanList);
		return mapping.findForward("dev_execute");
	}
	public ActionForward doDev_plan(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 SalPlanForm salPlanForm = (SalPlanForm)form;
		 SalPlan salPlan = new SalPlan();
		 salPlan.setChcId(salPlanForm.getChcId());
		 
		 salPlan.getSalChance().setChcId(salPlanForm.getChcId());
		 
		 salPlan.setPlaDate(salPlanForm.getPlaDate());
		 salPlan.setPlaTodo(salPlanForm.getPlaTodo());
		 
		 System.out.println(salPlan);
		 salPlanService.addSalPlan(salPlan);
		return new ActionForward("/salPlanAction.do?method=planList");
	
	}
	public ActionForward doDev_execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 SalPlanForm salPlanForm = (SalPlanForm)form;
		 SalPlan salPlan = new SalPlan();
		 /*salPlan.getSalChance().setChcId(salPlanForm.getSalChance().getChcId());
		 salPlan.setPlaDate(salPlanForm.getPlaDate());
		 salPlan.setPlaTodo(salPlanForm.getPlaTodo());
		 salPlanService.addSalPlan(salPlan);*/
		 salPlan.setPlaId(salPlanForm.getPlaId());
		 salPlan.setPlaResult(salPlanForm.getPlaResult());
		 salPlanService.updateSalPlan(salPlan);
		 System.out.println(salPlanForm.getPlaId()+" "+salPlanForm.getPlaResult());
		return new ActionForward("/salPlanAction.do?method=planList");
	}
	
	public ActionForward planList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//每页pageSize条
		SalPlanForm  salPlanForm = (SalPlanForm) form;
		//SalChanceForm salChanceForm = (SalChanceForm) form;
		int pageSize = 5;
		if (salPlanForm.getPageSize()>0) {
			pageSize=salPlanForm.getPageSize();
		}
		//分页信息
		int transmitPage=1;//默认是1
		if(request.getParameter("page") != null) {
			transmitPage = Integer.parseInt(request.getParameter("page"));
		}
		if (salPlanForm.getTransmitPage()>0) {
			transmitPage = salPlanForm.getTransmitPage();
		}
		//将当前页的信息保存到request中
		request.setAttribute("curPage", transmitPage);
		HttpSession session =	request.getSession();
		//条件一 ： 登陆者的权利ID
		Long  userRoleID =null;
		//登陆者的ID
		Long	usrID = null;
		if (session.getAttribute("loginViewObject")!=null) {
			LoginView loginViewObject = (LoginView)session.getAttribute("loginViewObject");
			userRoleID = loginViewObject.getUsrRoleId();
			usrID = loginViewObject.getUsrId();
		}
		String custName = salPlanForm.getChcCustName();  
		String chcTitle =salPlanForm.getChcTitle();
		String chcLinkman = salPlanForm.getChcLinkman();
		 //Set<SalChance> salPlansObjectList= (Set<SalChance>)
		String isChcStatus = "false";//没有指派
			List<SalChance> salPlansObjectList = salChanceService.getFindPropertySalChanceList(custName, chcTitle, chcLinkman, pageSize, transmitPage, userRoleID,usrID,isChcStatus);
			Long salPlansObjctCount = salChanceService.getFindPropertySalChanceCount(custName, chcTitle, chcLinkman, pageSize, transmitPage, userRoleID,usrID,isChcStatus);
			request.setAttribute("count", salPlansObjctCount);
		//salChanceForm.setSalPlans((Set) salPlansObjectList);
		request.setAttribute("salPlansObjectList", salPlansObjectList);
		//最大页数
		int totalPage =  (int) ((salPlansObjctCount % pageSize == 0) ?salPlansObjctCount / pageSize : salPlansObjctCount / pageSize+1);
		request.setAttribute("totalPage", totalPage);	
		return mapping.findForward("dev");
	}

}