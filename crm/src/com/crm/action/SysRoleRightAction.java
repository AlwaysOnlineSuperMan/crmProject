package com.crm.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.crm.biz.impl.ISysRightService;
import com.crm.dao.impl.ISysRightDAO;


public class SysRoleRightAction extends DispatchAction implements java.io.Serializable {
	private ISysRightService sysRightService;

	public void setSysRightService(ISysRightService sysRightService) {
		this.sysRightService = sysRightService;
	}
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		return super.execute(mapping, form, request, response);
	}
}