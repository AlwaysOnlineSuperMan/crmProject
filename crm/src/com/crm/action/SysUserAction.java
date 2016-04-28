package com.crm.action;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.crm.biz.impl.ISysRightService;
import com.crm.biz.impl.ISysRoleService;
import com.crm.biz.impl.ISysUserService;
import com.crm.dao.impl.ISysUserDAO;
import com.crm.entity.SysRole;
import com.crm.entity.SysUser;
import com.crm.form.SysUserForm;
import com.crm.util.PageModel;
import com.crm.view.LoginView;


public class SysUserAction extends DispatchAction implements java.io.Serializable {
	private ISysUserService sysUserService;
	private ISysRoleService sysRoleService;
	

	public void setSysRoleService(ISysRoleService sysRoleService) {
		this.sysRoleService = sysRoleService;
	}

	public void setSysUserService(ISysUserService sysUserService) {
		this.sysUserService = sysUserService;
	}
	
	public ActionForward login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SysUserForm sysUserForm = (SysUserForm) form;
		LoginView loginViewObject = sysUserService.findByUserNoAndPassWord(sysUserForm.getUsrNo(),sysUserForm.getUsrPassword());
		if (loginViewObject!=null) {
		HttpSession	session = request.getSession();
		System.out.println(loginViewObject);
		session.setAttribute("loginViewObject", loginViewObject);
		return mapping.findForward("index");
		}
		return mapping.findForward("toLogin");
		//	BeanUtils.copyProperties(loginViewObject, sysUserObject);
		//String roleName = 
		//	SysRole sysRole = sysRoleService.findByID(sysUserObject.getUsrRoleId());
		//	loginViewObject.setRoleName(sysRole.getRoleName());
	}
	public ActionForward bakeSystem(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession	session = request.getSession();
		session.removeAttribute("loginViewObject");
		return mapping.findForward("toLogin");
	}
	public ActionForward userAllList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<SysUser> sysUserObjectList =  sysUserService.getfindAllList();
		SysRole sysRoleObject =null;
		for (SysUser sysUser : sysUserObjectList) {
			Long roleId = sysUser.getUsrRoleId();
			if (roleId!=null&&roleId!=0) {
				sysRoleObject  = sysRoleService.findByID(roleId);
				sysUser.setUsrRoleName(sysRoleObject.getRoleName());
			}else{
				sysUser.setUsrRoleName("未指派 ");
			}
			
		}
		
	
		request.getSession().setAttribute("sysUserObjectList", sysUserObjectList);
		return mapping.findForward("toList");
	}
	
	
	
	
	
	//----------------------------------------------------------------------------------------------
	public ActionForward toUserListForPage(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SysUserForm sysUserForm = (SysUserForm) form;
		SysUser sysUser = new SysUser();
		sysUser.setUsrName(sysUserForm.getUsrName());
		sysUser.setUsrFlag(sysUserForm.getUsrFlag());
		PageModel<SysUser> pageModel=sysUserForm.getPageModel();
		int currPage = 1;
		if (sysUserForm.getPageModel().getCurrPage()!=0) {
			currPage=sysUserForm.getPageModel().getCurrPage();
		}
		int pageSize = 2;
		if (sysUserForm.getPageModel().getMaxRecord()!=0) {
			pageSize = sysUserForm.getPageModel().getMaxRecord();
		}
		pageModel  = sysUserService.getSysUserPageModel(sysUser, currPage,pageSize);
		List<SysUser> sysUserObjectList = pageModel.getResultList();
		SysRole sysRoleObject =null;
		for (SysUser sysUserObject : sysUserObjectList) {
			System.out.println(sysUserObject);
			Long roleId = sysUserObject.getUsrRoleId();
			if (roleId!=null&&roleId!=0) {
				sysRoleObject  = sysRoleService.findByID(roleId);
				sysUserObject.setUsrRoleName(sysRoleObject.getRoleName());
			}else{
				sysUserObject.setUsrRoleName("未指派 ");
			}
			
		}
		pageModel.setResultList(sysUserObjectList);
		sysUserForm.setPageModel(pageModel);
		return mapping.findForward("toList");
	}
	//--------------------------------------------------------------------------------------------------------------------------------------
	public ActionForward toUserAdd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		return mapping.findForward("toUserAdd");
	}
	public ActionForward doUserAdd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SysUserForm sysUserForm = (SysUserForm) form;
		SysUser sysUserObject = new SysUser();
		BeanUtils.copyProperties(sysUserObject, sysUserForm);
		//状态正常
		sysUserObject.setUsrFlag(1);
		sysUserObject.setUsrUpdateDatetime(new Timestamp(System.currentTimeMillis()));
		sysUserObject.setUsrId(null);
		System.out.println(sysUserObject);
		sysUserService.addUser(sysUserObject);
		return new ActionForward("/sysUserAction.do?method=toUserListForPage",true);
	}
	public ActionForward toUserEdit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Long userId=Long.valueOf(request.getParameter("userId"));
		SysUser sysUserObject =	sysUserService.getSysUserByID(userId);
		SysUserForm sysUserForm = (SysUserForm) form;
		BeanUtils.copyProperties(sysUserForm,sysUserObject);
		return mapping.findForward("toUserEdit");
	}
	public ActionForward doUserEdit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SysUserForm sysUserForm = (SysUserForm) form;
		SysUser sysUserObject = new SysUser();
		BeanUtils.copyProperties(sysUserObject, sysUserForm);
		//状态正常
		sysUserObject.setUsrFlag(1);
		sysUserObject.setUsrUpdateDatetime(new Timestamp(System.currentTimeMillis()));
		System.out.println(sysUserObject);
		sysUserService.addUser(sysUserObject);
		return new ActionForward("/sysUserAction.do?method=toUserListForPage",true);
	}
	public ActionForward toDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Long userId=Long.valueOf(request.getParameter("userId"));
		SysUser sysUserObject =	sysUserService.getSysUserByID(userId);
		SysUserForm sysUserForm = (SysUserForm) form;
		BeanUtils.copyProperties(sysUserForm,sysUserObject);
		SysRole sysRoleObject =null;
		Long roleId = sysUserObject.getUsrRoleId();
		if (roleId!=null&&roleId!=0) {
			sysRoleObject  = sysRoleService.findByID(roleId);
			sysUserForm.setUsrRoleName(sysRoleObject.getRoleName());
		}else{
			sysUserForm.setUsrRoleName("未指派 ");
		}
		return mapping.findForward("toDetail");
	}
	public ActionForward toDispatch(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Long userId=Long.valueOf(request.getParameter("userId"));
		SysUser sysUserObject =	sysUserService.getSysUserByID(userId);
		SysUserForm sysUserForm = (SysUserForm) form;
		BeanUtils.copyProperties(sysUserForm,sysUserObject);
		sysUserForm.setSysRoleList(sysRoleService.getSysRoleAll());
		return mapping.findForward("toDispatch");
	}
	public ActionForward doDispatch(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SysUserForm sysUserForm = (SysUserForm) form;
		SysUser sysUserObject = new SysUser();
		sysUserObject.setUsrId(sysUserForm.getUsrId());
		sysUserObject.setUsrRoleId(sysUserForm.getUsrRoleId());
		sysUserObject.setUsrUpdateDatetime(new Timestamp(System.currentTimeMillis()));
		System.out.println(sysUserObject);
		sysUserService.updUserByRoleID(sysUserObject);
		return new ActionForward("/sysUserAction.do?method=toUserListForPage",true);
	}
	public ActionForward toDelete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Long userId=Long.valueOf(request.getParameter("userId"));
		SysUser sysUserObject = new SysUser();
		sysUserObject.setUsrId(userId);
		System.out.println(sysUserObject);
		sysUserService.deleteByUserID(sysUserObject);
		return new ActionForward("/sysUserAction.do?method=toUserListForPage",true);
	}
}