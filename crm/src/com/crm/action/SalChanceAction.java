package com.crm.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.crm.biz.SysUserService;
import com.crm.biz.impl.ISalChanceService;
import com.crm.biz.impl.ISysUserService;
import com.crm.dao.impl.ISalChanceDAO;
import com.crm.dao.impl.ISysUserDAO;
import com.crm.entity.SalChance;
import com.crm.entity.SysUser;
import com.crm.form.SalChanceForm;
import com.crm.view.LoginView;
import com.sun.org.apache.commons.beanutils.BeanUtils;



public class SalChanceAction extends DispatchAction implements java.io.Serializable {

	private ISalChanceService salChanceService;
	private ISysUserService sysUserService;
	public void setSysUserService(ISysUserService sysUserService) {
		this.sysUserService = sysUserService;
	}
	public void setSalChanceService(ISalChanceService salChanceService) {
		this.salChanceService = salChanceService;
	}
	public ActionForward salChanceaManageList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	
	
		
		/*查询条件
		 * 1,登陆人的权利session.getAttribute("sysUserObject")!=null
		 * 2,客户名称 
		 * 3,概要
		 * 4,联系人
		 * 5,每页条数          pageSize     
		 * 6,第页/共5页
		 * 
		 * */
		
		/*
		 * 营销管理：											
		"<1>销售机会管理：
"		涉及表： 1,sal_chance 销售机会表  
			    2,管理者信息表---dbo.sys_user		
				3,权限表（sys_role）		
		
		操作者：	销售主管	客户经理
			==》dbo.sys_user --> usr_role_id		inner join 权限表（sys_role）role_id in(1,2)
		功能：
		 一：查询：									
		    1.显示信息：只显示状态为“未分配”的，分页显示
		     ==》 sal_chance --> chc_status in(1)	
		    2.查询：根据条件进行模糊查询（注意数据分页）	
		    ==》 sal_chance --> custName 或者 chcTitle 或者 chcLinkman	
								
		    
		    4.指派：除指派人，指派时间（格式：YYYY-MM-dd）外，其他信息均为只读，不可操作，销售机会状态改为“已指派”。									
		    5.修改：可以对机会来源、客户名称、成功机率、概要、联系人、联系人电话、机会描述进行编辑。此时的编号，指派对象框和指派时间框是不可操作的									
		    6.删除：需要判断当前登录用户为该销售机会的创建人，否则不可删除。提示用户，是否确认删除，客户选择“是”才可进行删除									
		    7.保存：提示“保存成功”，或报告相应错误。页面必填项未填时不允许提交表单，并更改数据库，跳转回显示全部页面。									
		 */
		//每页pageSize条
		SalChanceForm salChanceForm = (SalChanceForm) form;
		int pageSize = 5;
		if (salChanceForm.getPageSize()>0) {
			pageSize=salChanceForm.getPageSize();
		}
		//分页信息
		int transmitPage=1;//默认是1
		if(request.getParameter("page") != null) {
			transmitPage = Integer.parseInt(request.getParameter("page"));
		}
		if (salChanceForm.getTransmitPage()>0) {
			transmitPage = salChanceForm.getTransmitPage();
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
		String custName = salChanceForm.getChcCustName();
		String chcTitle = salChanceForm.getChcTitle();
		String chcLinkman = salChanceForm.getChcLinkman();
		 //Set<SalChance> salPlansObjectList= (Set<SalChance>)
		String isChcStatus = "true";//true没有指派
			List<SalChance> salPlansObjectList = salChanceService.getFindPropertySalChanceList(custName, chcTitle, chcLinkman, pageSize, transmitPage, userRoleID,usrID,isChcStatus);
			Long salPlansObjctCount = salChanceService.getFindPropertySalChanceCount(custName, chcTitle, chcLinkman, pageSize, transmitPage, userRoleID,usrID,isChcStatus);
		
			request.setAttribute("count", salPlansObjctCount);
		//salChanceForm.setSalPlans((Set) salPlansObjectList);
		request.setAttribute("salPlansObjectList", salPlansObjectList);
		//最大页数
		int totalPage =  (int) ((salPlansObjctCount % pageSize == 0) ?salPlansObjctCount / pageSize : salPlansObjctCount / pageSize+1);
		request.setAttribute("totalPage", totalPage);		
		
		return mapping.findForward("list");
	}
	
	
	public ActionForward toSalPlanAdd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
/*		 二：新建：
		    3.新建销售机会：
		             对创建任何时间进行绑定，
		              创建人只能是当前登录人，
		              时间为当前时间，
		              编号是自增的，
		           此时的指派对象框和指派时间框是不可操作的。
		    */		
		SalChanceForm salChanceForm = (SalChanceForm) form;
		HttpSession session =	request.getSession();
		
		//登陆者的ID
		Long	usrID = (long)0;
		if (session.getAttribute("loginViewObject")!=null) {
			LoginView loginViewObject = (LoginView)session.getAttribute("loginViewObject");
			usrID = loginViewObject.getUsrId();
		}
		salChanceForm.setChcCreateId(usrID);
		salChanceForm.setChcCreateDate(new Timestamp(System.currentTimeMillis()));
		salChanceForm.setChcId((long)1);
		return mapping.findForward("add");
	}
	
	
	
	
	public ActionForward doSalPlanAdd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		SalChanceForm salChanceForm = (SalChanceForm) form;
		SalChance salChanceObject = new SalChance();
		//BeanUtils.copyProperties(salChanceObject, salChanceForm);
		salChanceObject.setChcStatus("1");
		salChanceObject.setChcCreateId(salChanceForm.getChcCreateId());
		salChanceObject.setChcId(salChanceForm.getChcId());
		salChanceObject.setChcSource(salChanceForm.getChcSource());
		salChanceObject.setChcCustName(salChanceForm.getChcCustName());
		salChanceObject.setChcRate(salChanceForm.getChcRate());
		salChanceObject.setChcTitle(salChanceForm.getChcTitle());
		salChanceObject.setChcLinkman(salChanceForm.getChcLinkman());
		salChanceObject.setChcTel(salChanceForm.getChcTel());
		salChanceObject.setChcDesc(salChanceForm.getChcDesc());
		salChanceObject.setChcCreateDate(salChanceForm.getChcCreateDate());
		salChanceObject.setChcCreateBy(salChanceForm.getChcCreateBy());
		salChanceObject.setChcCreateDate(salChanceForm.getChcCreateDate());
		salChanceObject.setChcUpdateDatetime(salChanceForm.getChcCreateDate());
		
		
		salChanceService.addSalChanceSeva(salChanceObject);
		return new ActionForward("/salChanceAction.do?method=salChanceaManageList",true);
	}
	
	public ActionForward toSalPlaneEdit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		SalChanceForm salChanceForm = (SalChanceForm) form;
	
		Long chcId =Long.parseLong(request.getParameter("chcId"));
		SalChance salChance = salChanceService.getSalChanceByID(chcId);
		//BeanUtils.copyProperties(salChanceForm, salChanceObject);
		salChanceForm.setChcId(salChance.getChcId());
		salChanceForm.setChcCreateId(salChance.getChcCreateId());
		salChanceForm.setChcSource(salChance.getChcSource());
		salChanceForm.setChcCustName(salChance.getChcCustName());
		salChanceForm.setChcRate(salChance.getChcRate());
		salChanceForm.setChcTitle(salChance.getChcTitle());
		salChanceForm.setChcLinkman(salChance.getChcLinkman());
		salChanceForm.setChcTel(salChance.getChcTel());
		salChanceForm.setChcDesc(salChance.getChcDesc());
		salChanceForm.setChcCreateDate(salChance.getChcCreateDate());
		salChanceForm.setChcCreateBy(salChance.getChcCreateBy());
		salChanceForm.setChcCreateDate(salChance.getChcCreateDate());
		salChanceForm.setChcUpdateDatetime(salChance.getChcUpdateDatetime());
		
		return mapping.findForward("toEdit");
		
	}
	public ActionForward doSalPlaneEdit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		SalChanceForm salChanceForm = (SalChanceForm) form;
		SalChance salChanceObject = new SalChance();
		//BeanUtils.copyProperties(salChanceObject, salChanceForm);
		salChanceObject.setChcStatus("1");
		salChanceObject.setChcCreateId(salChanceForm.getChcCreateId());
		salChanceObject.setChcId(salChanceForm.getChcId());
		salChanceObject.setChcSource(salChanceForm.getChcSource());
		salChanceObject.setChcCustName(salChanceForm.getChcCustName());
		salChanceObject.setChcRate(salChanceForm.getChcRate());
		salChanceObject.setChcTitle(salChanceForm.getChcTitle());
		salChanceObject.setChcLinkman(salChanceForm.getChcLinkman());
		salChanceObject.setChcTel(salChanceForm.getChcTel());
		salChanceObject.setChcDesc(salChanceForm.getChcDesc());
		salChanceObject.setChcCreateDate(salChanceForm.getChcCreateDate());
		salChanceObject.setChcCreateBy(salChanceForm.getChcCreateBy());
		salChanceObject.setChcCreateDate(salChanceForm.getChcCreateDate());
		salChanceObject.setChcUpdateDatetime(salChanceForm.getChcUpdateDatetime());
		System.out.println(salChanceForm.getChcUpdateDatetime());
		salChanceService.addSaveOrUpdate(salChanceObject);
		
		
		return new ActionForward("/salChanceAction.do?method=salChanceaManageList",true);
	}
	public ActionForward salPlaneDelete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Long chcId =Long.parseLong(request.getParameter("chcId"));
		salChanceService.delSalChance(chcId);
		return new ActionForward("/salChanceAction.do?method=salChanceaManageList",true);
	}
	
	
	
	public ActionForward toDispatch(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SalChanceForm salChanceForm = (SalChanceForm) form;
		Long chcId =Long.parseLong(request.getParameter("chcId"));
		SalChance salChance = salChanceService.getSalChanceByID(chcId);
		List<SysUser> sysUserList= sysUserService.getSysUserObjectList();
		salChanceForm.setSysUserList(sysUserList);
		//BeanUtils.copyProperties(salChanceForm, salChanceObject);
		salChanceForm.setChcId(salChance.getChcId());
		salChanceForm.setChcCreateId(salChance.getChcCreateId());
		salChanceForm.setChcSource(salChance.getChcSource());
		salChanceForm.setChcCustName(salChance.getChcCustName());
		salChanceForm.setChcRate(salChance.getChcRate());
		salChanceForm.setChcTitle(salChance.getChcTitle());
		salChanceForm.setChcLinkman(salChance.getChcLinkman());
		salChanceForm.setChcTel(salChance.getChcTel());
		salChanceForm.setChcDesc(salChance.getChcDesc());
		salChanceForm.setChcCreateDate(salChance.getChcCreateDate());
		salChanceForm.setChcCreateBy(salChance.getChcCreateBy());
		salChanceForm.setChcCreateDate(salChance.getChcCreateDate());
		salChanceForm.setChcUpdateDatetime(salChance.getChcUpdateDatetime());
		
		
		
		return mapping.findForward("toDispatch");
	}
	public ActionForward doDispatch(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SalChanceForm salChanceForm = (SalChanceForm) form;
		SalChance salChanceObject = new SalChance();
		//BeanUtils.copyProperties(salChanceObject, salChanceForm);
		salChanceObject.setChcId(salChanceForm.getChcId());
		salChanceObject.setChcDueDate(salChanceForm.getChcDueDate());
		salChanceObject.setChcDueId(salChanceForm.getChcDueId());
		salChanceObject.setChcDueTo(sysUserService.getSysUserByID(salChanceForm.getChcDueId()).getUsrName());
		salChanceObject.setChcUpdateDatetime(salChanceForm.getChcUpdateDatetime());
		salChanceService.updDispatch(salChanceObject);
		
		return new ActionForward("/salChanceAction.do?method=salChanceaManageList",true);
	}
	
	
	
	/*"<2>客户开发计划：
	"										
		操作者：	客户经理								
		涉及表：	sal_chance 销售机会， sal_plan 销售计划								
		功能：									
		    1.显示信息：只显示状态为“已分配”的销售机会，分页显示									
		    2.查询：根据条件进行模糊查询（注意数据分页）									
		    3.制定开发计划：显示出销售机会的详细信息，也可编辑已经有的计划项（删除，修改），日期不可以编辑。提交并更新当前页面时在计划项列表中显示新建的计划项									
		    4.执行计划：对每个计划项填写执行效果，并保存。									
		    5.开发成功：需修改销售机会的状态为“开发成功”。并根据销售机会中相应信息自动创建客户记录（在cst_customer 客户表新增），跳转回显示全部页面。									
		    6.终止开发：修改销售机会的状态为“开发失败”，跳转回显示全部页面。									
		    7.保存：提示“保存成功”，或报告相应错误。页面必填项未填时不允许提交表单，并更改数据库，跳转回显示全部页面。									
*/
	public ActionForward salChanceList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//每页pageSize条
		SalChanceForm salChanceForm = (SalChanceForm) form;
		int pageSize = 5;
		if (salChanceForm.getPageSize()>0) {
			pageSize=salChanceForm.getPageSize();
		}
		//分页信息
		int transmitPage=1;//默认是1
		if(request.getParameter("page") != null) {
			transmitPage = Integer.parseInt(request.getParameter("page"));
		}
		if (salChanceForm.getTransmitPage()>0) {
			transmitPage = salChanceForm.getTransmitPage();
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
		String custName = salChanceForm.getChcCustName();
		String chcTitle = salChanceForm.getChcTitle();
		String chcLinkman = salChanceForm.getChcLinkman();
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
	public ActionForward loseSalChance(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Long chcId =Long.valueOf(request.getParameter("chcId"));
		SalChance salChanceObject = new SalChance();
		salChanceObject.setChcId(chcId);
		salChanceService.updloseSalChance(salChanceObject);
		return new ActionForward("/salPlanAction.do?method=planList");
	}
}