package com.crm.action;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.crm.biz.impl.ISysRoleService;
import com.crm.dao.impl.ISysRoleDAO;
import com.crm.entity.SysRole;
import com.crm.entity.SysUser;
import com.crm.form.SysRoleForm;
import com.crm.form.SysUserForm;
import com.crm.util.PageModel;


public class SysRoleAction extends DispatchAction implements java.io.Serializable {
	private ISysRoleService sysRoleService;

	public void setSysRoleService(ISysRoleService sysRoleService) {
		this.sysRoleService = sysRoleService;
	}
	public ActionForward toRoleAllList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SysRoleForm sysRoleForm = (SysRoleForm) form;
		PageModel<SysRole> pageModel=sysRoleForm.getPageModel();
		int currPage = 1;
		if (pageModel.getCurrPage()!=0) {
			currPage=sysRoleForm.getPageModel().getCurrPage();
		}
		int pageSize = 2;
		if (pageModel.getMaxRecord()!=0) {
			pageSize = sysRoleForm.getPageModel().getMaxRecord();
		}
		SysRole sysRole= new SysRole();
		BeanUtils.copyProperties(sysRole, sysRoleForm);
		System.out.println(sysRole);
		pageModel  = sysRoleService.getPageModel(sysRole, currPage,pageSize);
		sysRoleForm.setPageModel(pageModel);
		return mapping.findForward("toRoleList");
	}
	public ActionForward toAddSysRole(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SysRoleForm sysRoleForm = new SysRoleForm();
		SysRole sysRole = new SysRole();
		BeanUtils.copyProperties(sysRole, sysRoleForm);
		//正常
		sysRole.setRoleFlag(1);
		sysRole.setRoleUpdateDatetime((new Timestamp(System.currentTimeMillis()).toString()));
		sysRoleService.addRole(sysRole);
		return new ActionForward("/sysRoleAction.do?method=toRoleAllList",true);
	}
	public ActionForward toEditSysRole(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Long roleId = Long.valueOf(request.getParameter("roleId"));
		SysRole	sysRole=  sysRoleService.findByID(roleId);
		SysRoleForm sysRoleForm = (SysRoleForm) form;
		sysRoleForm.setRoleId(sysRole.getRoleId());
		sysRoleForm.setRoleDesc(sysRole.getRoleDesc());
		sysRoleForm.setRoleName(sysRole.getRoleName());
		sysRoleForm.setRoleFlag(sysRole.getRoleFlag());
		sysRoleForm.setRoleUpdateDatetime((new Timestamp(System.currentTimeMillis())).toString());
		return mapping.findForward("toRoleEdit");
	}
	public ActionForward doEditSysRole(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SysRoleForm sysRoleForm = (SysRoleForm) form;
		SysRole sysRole = new SysRole();
		BeanUtils.copyProperties(sysRole, sysRoleForm);
		//正常
		sysRole.setRoleFlag(sysRoleForm.getRoleFlag());
		sysRole.setRoleUpdateDatetime((new Timestamp(System.currentTimeMillis()).toString()));
		sysRole.setSysRoleRights(null);
		System.out.println(sysRole);
		sysRoleService.addRole(sysRole);
		return new ActionForward("/sysRoleAction.do?method=toRoleAllList",true);
	}
	
	public ActionForward toDispatchRight(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<SysRole> sysRoleObjectList = sysRoleService.getSysRoleAll();
		request.getSession().setAttribute("sysRoleObjectList", sysRoleObjectList)	;	
		return mapping.findForward("toDispatchRight");
	}
	public ActionForward toDetailSysRole(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Long roleId = Long.valueOf(request.getParameter("roleId"));
		SysRole	sysRole=  sysRoleService.findByID(roleId);
		System.out.println(sysRole.getRoleFlag());
		SysRoleForm sysRoleForm = (SysRoleForm) form;
		sysRoleForm.setRoleId(sysRole.getRoleId());
		sysRoleForm.setRoleDesc(sysRole.getRoleDesc());
		sysRoleForm.setRoleName(sysRole.getRoleName());
		sysRoleForm.setRoleFlag(sysRole.getRoleFlag());
		sysRoleForm.setRoleUpdateDatetime((new Timestamp(System.currentTimeMillis())).toString());
		return mapping.findForward("toDetail");
	}
	
	public ActionForward toDeleteSysRole(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Long roleId = Long.valueOf(request.getParameter("roleId"));
		System.out.println(roleId+"=========");
		sysRoleService.delRole(roleId);
		return new ActionForward("/sysRoleAction.do?method=toRoleAllList",true);
	}

	public ActionForward doAddSysRole(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SysRoleForm sysRoleForm = (SysRoleForm) form;
		SysRole sysRole = new SysRole();
		BeanUtils.copyProperties(sysRole, sysRoleForm);
		//正常
		sysRole.setRoleFlag(sysRoleForm.getRoleFlag());
		sysRole.setRoleUpdateDatetime((new Timestamp(System.currentTimeMillis()).toString()));
		sysRole.setSysRoleRights(null);
		sysRole.setRoleId(null);
		System.out.println(sysRole);
		System.out.println("===="+sysRoleForm.getRoleName());
		sysRoleService.addRole(sysRole);
		return new ActionForward("/sysRoleAction.do?method=toRoleAllList",true);
		}
}