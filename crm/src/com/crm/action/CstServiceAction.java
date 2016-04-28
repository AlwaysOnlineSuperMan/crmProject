package com.crm.action;


import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;


import com.crm.biz.impl.IBasDictService;
import com.crm.biz.impl.ICstCustomerService;
import com.crm.biz.impl.ICstServiceService;
import com.crm.biz.impl.ISysUserService;
import com.crm.dao.CstServiceDAO;
import com.crm.entity.BasDict;
import com.crm.entity.CstCustomer;
import com.crm.entity.CstService;
import com.crm.entity.SysUser;
import com.crm.form.CstServiceForm;
import com.crm.form.SysUserForm;
import com.crm.view.LoginView;

@SuppressWarnings("serial")
public class CstServiceAction extends DispatchAction implements java.io.Serializable {
	private CstServiceDAO cstServiceDAO=new CstServiceDAO();
	private ICstCustomerService cstCustomerService;
	private IBasDictService basDictService;
	private ISysUserService sysUserService;
	private ICstServiceService cstServiceService;
	public ICstServiceService getCstServiceService() {
		return cstServiceService;
	}
	public ICstCustomerService getCstCustomerService() {
		return cstCustomerService;
	}
	public IBasDictService getBasDictService() {
		return basDictService;
	}
	public void setCstCustomerService(ICstCustomerService cstCustomerService) {
		this.cstCustomerService = cstCustomerService;
	}
	public void setBasDictService(IBasDictService basDictService) {
		this.basDictService = basDictService;
	}
	public void setCstServiceService(ICstServiceService cstServiceService) {
		this.cstServiceService = cstServiceService;
	}
	public ISysUserService getSysUserService() {
		return sysUserService;
	}
	public void setSysUserService(ISysUserService sysUserService) {
		this.sysUserService = sysUserService;
	}
	//修改服务归档
	public ActionForward updateFeedBack(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			CstServiceForm f=(CstServiceForm) form;
			CstService s = f.getCstservice();
			String parameter = request.getParameter("id");
			Long id=Long.valueOf(parameter);
			CstService byid = cstServiceService.FindServiceById(id);
			byid.setSvrResult(s.getSvrResult());
			byid.setSvrSatisfy(s.getSvrSatisfy());
			byid.setSvrStatus("已归档");
			cstServiceService.updateService(byid);
			String str = "/cstServiceAction.do?method=findAll3";
			return new ActionForward(str);
		}
	
	//反馈条件查询
	public ActionForward selByService(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session=request.getSession();
		
		String svrStatus=null;
		if(request.getParameter("svrStatus")!=null&&!request.getParameter("svrStatus").equals("")){
			svrStatus = request.getParameter("svrStatus");
		}
		//String uri=request.getParameter("uri");
		
		String svrCustName =null;
		if(request.getParameter("svrCustName")!=null&&!request.getParameter("svrCustName").equals("")){
			svrCustName = request.getParameter("svrCustName");
		}
		String svrTitle =null;
		if(request.getParameter("svrTitle")!=null&&!request.getParameter("svrTitle").equals("")){
			svrTitle = request.getParameter("svrTitle");
		}
		String svrType =null;
		if(request.getParameter("svrType")!=null&&!request.getParameter("svrType").equals("")){
			svrType = request.getParameter("svrType");
		}
		String svrCreateDate1 =null;
		if(request.getParameter("svrCreateDate1")!=null&&!request.getParameter("svrCreateDate1").equals("")){
			svrCreateDate1 = request.getParameter("svrCreateDate1");
		}
		String svrCreateDate2 =null;
		if(request.getParameter("svrCreateDate2")!=null&&!request.getParameter("svrCreateDate2").equals("")){
			svrCreateDate2 = request.getParameter("svrCreateDate2");
		}
		
		CstService cs=new CstService();
		cs.setSvrStatus(svrStatus);
		cs.setSvrCustName(svrCustName);
		cs.setSvrTitle(svrTitle);
		cs.setSvrType(svrType);
		List<SysUser> listsys = sysUserService.fillAll();
		List<CstService> list = cstServiceService.listAll(cs,svrCreateDate1,svrCreateDate2);
	//	List<BasDict> listb1=basDictService.findTypeByServiceType();
		//session.setAttribute("listb1", listb1);
		session.setAttribute("list", list);
		session.setAttribute("listsys", listsys);
		return mapping.findForward("select3");
	}
	
	//处理条件查询
	public ActionForward selByService1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session=request.getSession();
		
		String svrStatus=null;
		if(request.getParameter("svrStatus")!=null&&!request.getParameter("svrStatus").equals("")){
			svrStatus = request.getParameter("svrStatus");
		}
		//String uri=request.getParameter("uri");
		
		String svrCustName =null;
		if(request.getParameter("svrCustName")!=null&&!request.getParameter("svrCustName").equals("")){
			svrCustName = request.getParameter("svrCustName");
		}
		String svrTitle =null;
		if(request.getParameter("svrTitle")!=null&&!request.getParameter("svrTitle").equals("")){
			svrTitle = request.getParameter("svrTitle");
		}
		String svrType =null;
		if(request.getParameter("svrType")!=null&&!request.getParameter("svrType").equals("")){
			svrType = request.getParameter("svrType");
		}
		String svrCreateDate1 =null;
		if(request.getParameter("svrCreateDate1")!=null&&!request.getParameter("svrCreateDate1").equals("")){
			svrCreateDate1 = request.getParameter("svrCreateDate1");
		}
		String svrCreateDate2 =null;
		if(request.getParameter("svrCreateDate2")!=null&&!request.getParameter("svrCreateDate2").equals("")){
			svrCreateDate2 = request.getParameter("svrCreateDate2");
		}
		
		CstService cs=new CstService();
		cs.setSvrStatus(svrStatus);
		cs.setSvrCustName(svrCustName);
		cs.setSvrTitle(svrTitle);
		cs.setSvrType(svrType);
		List<SysUser> listsys = sysUserService.fillAll();
		List<CstService> list = cstServiceService.listAll(cs,svrCreateDate1,svrCreateDate2);
	//	List<BasDict> listb1=basDictService.findTypeByServiceType();
		//session.setAttribute("listb1", listb1);
		session.setAttribute("list", list);
		session.setAttribute("listsys", listsys);
		return mapping.findForward("select2");
	}
	
	//分配条件查询
	public ActionForward selByService2(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session=request.getSession();
		
		String svrStatus=null;
		if(request.getParameter("svrStatus")!=null&&!request.getParameter("svrStatus").equals("")){
			svrStatus = request.getParameter("svrStatus");
		}
		//String uri=request.getParameter("uri");
		
		String svrCustName =null;
		if(request.getParameter("svrCustName")!=null&&!request.getParameter("svrCustName").equals("")){
			svrCustName = request.getParameter("svrCustName");
		}
		String svrTitle =null;
		if(request.getParameter("svrTitle")!=null&&!request.getParameter("svrTitle").equals("")){
			svrTitle = request.getParameter("svrTitle");
		}
		String svrType =null;
		if(request.getParameter("svrType")!=null&&!request.getParameter("svrType").equals("")){
			svrType = request.getParameter("svrType");
		}
		String svrCreateDate1 =null;
		if(request.getParameter("svrCreateDate1")!=null&&!request.getParameter("svrCreateDate1").equals("")){
			svrCreateDate1 = request.getParameter("svrCreateDate1");
		}
		String svrCreateDate2 =null;
		if(request.getParameter("svrCreateDate2")!=null&&!request.getParameter("svrCreateDate2").equals("")){
			svrCreateDate2 = request.getParameter("svrCreateDate2");
		}
		
		CstService cs=new CstService();
		cs.setSvrStatus(svrStatus);
		cs.setSvrCustName(svrCustName);
		cs.setSvrTitle(svrTitle);
		cs.setSvrType(svrType);
		List<SysUser> listsys = sysUserService.fillAll();
		List<CstService> list = cstServiceService.listAll(cs,svrCreateDate1,svrCreateDate2);
	//	List<BasDict> listb1=basDictService.findTypeByServiceType();
		//session.setAttribute("listb1", listb1);
		session.setAttribute("list", list);
		session.setAttribute("listsys", listsys);
		return mapping.findForward("select");
	}
	
	//归档条件查询
	public ActionForward selByService3(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session=request.getSession();
		
		String svrStatus=null;
		if(request.getParameter("svrStatus")!=null&&!request.getParameter("svrStatus").equals("")){
			svrStatus = request.getParameter("svrStatus");
		}
		//String uri=request.getParameter("uri");
		
		String svrCustName =null;
		if(request.getParameter("svrCustName")!=null&&!request.getParameter("svrCustName").equals("")){
			svrCustName = request.getParameter("svrCustName");
		}
		String svrTitle =null;
		if(request.getParameter("svrTitle")!=null&&!request.getParameter("svrTitle").equals("")){
			svrTitle = request.getParameter("svrTitle");
		}
		String svrType =null;
		if(request.getParameter("svrType")!=null&&!request.getParameter("svrType").equals("")){
			svrType = request.getParameter("svrType");
		}
		String svrCreateDate1 =null;
		if(request.getParameter("svrCreateDate1")!=null&&!request.getParameter("svrCreateDate1").equals("")){
			svrCreateDate1 = request.getParameter("svrCreateDate1");
		}
		String svrCreateDate2 =null;
		if(request.getParameter("svrCreateDate2")!=null&&!request.getParameter("svrCreateDate2").equals("")){
			svrCreateDate2 = request.getParameter("svrCreateDate2");
		}
		
		CstService cs=new CstService();
		cs.setSvrStatus(svrStatus);
		cs.setSvrCustName(svrCustName);
		cs.setSvrTitle(svrTitle);
		cs.setSvrType(svrType);
		List<SysUser> listsys = sysUserService.fillAll();
		List<CstService> list = cstServiceService.listAll(cs,svrCreateDate1,svrCreateDate2);
	//	List<BasDict> listb1=basDictService.findTypeByServiceType();
		//session.setAttribute("listb1", listb1);
		session.setAttribute("list", list);
		session.setAttribute("listsys", listsys);
		return mapping.findForward("select1");
	}
	//查ID
	public ActionForward findById(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Long id=Long.parseLong(request.getParameter("id"));
		CstService fid=cstServiceService.FindServiceById(id);
		CstServiceForm f=(CstServiceForm) form;
		f.setSvrId(fid.getSvrId());
		request.setAttribute("fid", fid);
		return mapping.findForward("deal");
	}
	//点击服务处理的跳转
	public ActionForward updateDispatch(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			CstServiceForm f=(CstServiceForm) form;
			CstService ById = cstServiceService.FindServiceById(f.getSvrId());
			ById.setSvrDueId(f.getCstservice().getSvrDueId());
			ById.setSvrDueTo(f.getCstservice().getSvrDueTo());
			ById.setSvrDueDate(new java.sql.Timestamp(System.currentTimeMillis()));
			ById.setSvrStatus("已分配");
			cstServiceService.updateService(ById);
			return mapping.findForward("selByService");
		}
	//服务类型
	private void serviceType(HttpServletRequest request) {
		List<BasDict> type = basDictService.findTypeByServiceType();
		request.setAttribute("type", type);
	}
	//服务处理
	public ActionForward edit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CstServiceForm f=(CstServiceForm) form;
		Long svrId =Long.parseLong(request.getParameter("svrId"));
		CstService ById = cstServiceService.FindServiceById(svrId);
		ById.setSvrDealDate(f.getSvrDealDate());
		ById.setSvrDealBy(f.getSvrDealBy());
		ById.setSvrDeal(f.getSvrDeal());
		ById.setSvrDealId(Long.valueOf("1"));
		ById.setSvrStatus("已处理");
		cstServiceService.updateService(ById);
		String str = "/cstServiceAction.do?method=findAll3";
		return new ActionForward(str);
	}
	//归档
	public ActionForward FindByIdFeedBack(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			Long id=Long.valueOf(request.getParameter("id"));
			CstService ById = cstServiceService.FindServiceById(id);
			request.setAttribute("byid", ById);
			return mapping.findForward("FeedbackDetail");
	}
	//查看
	public ActionForward FindByDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			Long id=Long.valueOf(request.getParameter("id"));
			CstService ById = cstServiceService.FindServiceById(id);
			List list=new ArrayList();
			if(ById.getSvrSatisfy()!=null && ById.getSvrSatisfy()!=0){
			Integer svrSatisfy = ById.getSvrSatisfy();
				for (int i = 0; i < svrSatisfy; i++) {
					list.add("");
				}
			}
			request.setAttribute("list", list);
			request.setAttribute("byid", ById);
			return mapping.findForward("Detail");
		}
	public ActionForward editGuiDang(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CstServiceForm f=(CstServiceForm) form;
		CstService s = f.getCstservice();
		String parameter = request.getParameter("id");
		Long id=Long.valueOf(parameter);
		CstService byid = cstServiceService.FindServiceById(id);
		byid.setSvrResult(s.getSvrResult());
		byid.setSvrSatisfy(s.getSvrSatisfy());
		byid.setSvrStatus("已归档");
		System.out.println(byid);
		cstServiceService.updateService(byid);
		return mapping.findForward("Feedback");
	}
	//分配中的显示所有
	public ActionForward findAll(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		serviceType(request);
		List<SysUser> sysUser =sysUserService.sel();
		request.setAttribute("sysUser", sysUser);
		List<CstService> list=cstServiceService.getAllService();
		request.setAttribute("list", list);
		return mapping.findForward("select");
	}
	//归档中的显示所有
	public ActionForward findAll1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		serviceType(request);
		List<CstService> list=cstServiceService.getAllServiceGuiDang();
		request.setAttribute("list", list);
		return mapping.findForward("select1");
	}
	//处理中的显示所有
	public ActionForward findAll2(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		serviceType(request);
		List<CstService> list=cstServiceService.getAllServiceChuLi();
		request.setAttribute("list", list);
		return mapping.findForward("select2");
	}
	//反馈中的显示所有
	public ActionForward findAll3(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		serviceType(request);
		List<CstService> list=cstServiceService.getAllServiceFanKui();
		request.setAttribute("list", list);
		return mapping.findForward("select3");
	}
	// 删除
	public ActionForward delService(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Long id =Long.parseLong(request.getParameter("svrId"));
		cstServiceService.del(id);
		return new ActionForward("/cstServiceAction.do?method=findAll");
	}
	//新建服务
	public ActionForward toCstServiceAdd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session =	request.getSession();
		Long	usrID = (long)0;
		if (session.getAttribute("loginViewObject")!=null) {
			LoginView loginViewObject = (LoginView)session.getAttribute("loginViewObject");
			usrID = loginViewObject.getUsrId();
		}
		LoginView loginView = (LoginView) request.getSession().getAttribute("loginViewObject");
		CstServiceForm cstServiceForm = (CstServiceForm) form;
		List<BasDict> BasDictObjectList = basDictService.findTypeByServiceType();
		cstServiceForm.setSvrCreateId(usrID);
		cstServiceForm.setBasDictList(BasDictObjectList);
		cstServiceForm.setSvrCreateBy(loginView.getUsrName());
		cstServiceForm.setSvrCreateDate(new Timestamp(System.currentTimeMillis()));
		cstServiceForm.setSvrStatus("新创建");
		return mapping.findForward("toCstServiceAdd");
	}
	public ActionForward doCstServiceAdd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CstServiceForm cstServiceForm = (CstServiceForm) form;
		CstService cstService=new CstService();
		cstService.setSvrCreateId(cstServiceForm.getSvrCreateId());
		cstService.setSvrType(cstServiceForm.getSvrType());
		cstService.setSvrTitle(cstServiceForm.getSvrTitle());
		cstService.setSvrCustName(cstServiceForm.getSvrCustName());
		cstService.setSvrStatus(cstServiceForm.getSvrStatus());
		cstService.setSvrRequest(cstServiceForm.getSvrRequest());
		cstService.setSvrCreateBy(cstServiceForm.getSvrCreateBy());
		cstService.setSvrCreateDate(cstServiceForm.getSvrCreateDate());
		cstService.setSvrUpdateDatetime((new Timestamp(System.currentTimeMillis()).toString()));
		cstServiceService.addCstService(cstService);
		return new ActionForward("/cstServiceAction.do?method=toCstServiceAdd",true);
	}
	//新建服务跳转的页面
	public ActionForward toCstServiceList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<SysUser> sysUser =sysUserService.sel();
		request.setAttribute("sysUser", sysUser);
		List<CstService> list=cstServiceService.getAllService();
		request.setAttribute("list", list);
		return mapping.findForward("dispatch");
	}
	public ActionForward toSerList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 List<String[]> strArrayList = cstServiceService.findServicByDict();
		request.setAttribute("strArrayList", strArrayList);
		return mapping.findForward("toSer");
	}
}