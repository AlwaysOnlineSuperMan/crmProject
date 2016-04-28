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

import com.crm.biz.impl.IBasDictService;
import com.crm.entity.BasDict;
import com.crm.entity.SysRole;
import com.crm.entity.SysUser;
import com.crm.form.BasDictForm;
import com.crm.util.PageModel;


public class BasDictAction  extends DispatchAction implements java.io.Serializable {
	private IBasDictService basDictService;
	public void setBasDictService(IBasDictService basDictService) {
		this.basDictService = basDictService;
	}
	public ActionForward toBasDictList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		BasDictForm basDictForm = (BasDictForm) form;
		PageModel<BasDict> pageModel = basDictForm.getPageModel();
		int currPage = 1;
		if (pageModel.getCurrPage()!=0) {
			currPage=pageModel.getCurrPage();
		}
		int pageSize = 2;
		if (pageModel.getMaxRecord()!=0) {
			pageSize = pageModel.getMaxRecord();
		}
		
		BasDict basDict = new BasDict();
		BeanUtils.copyProperties(basDict, basDictForm);
		System.out.println(basDict);
		pageModel = basDictService.getPageModel(basDict, currPage, pageSize);
		System.out.println(pageModel);
		basDictForm.setPageModel(pageModel);
		
		
		/*List<BasDict> basDictObjectList = basDictService.getDasDictAll();
		basDictForm.setBasDictObjectList(basDictObjectList);*/
		return mapping.findForward("toDict");
	}
	
	public ActionForward toDictAdd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("toDictAdd");
	}
	public ActionForward doDictAdd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		BasDictForm basDictForm = (BasDictForm) form;
		BasDict basDict = new BasDict();
		BeanUtils.copyProperties(basDict,basDictForm);
		basDict.setDictUpdateDatetime(new Timestamp(System.currentTimeMillis()));
		basDict.setDictId(null);
		System.out.println(basDict);
		basDictService.addOrUpdateBasDict(basDict);
		return new ActionForward("/basDictAction.do?method=toBasDictList");
	}
	public ActionForward toDictEdit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Long dictId=Long.valueOf(request.getParameter("dictId"));
		BasDict basDict = basDictService.getBasDictByID(dictId);
		BasDictForm basDictForm = (BasDictForm) form;
		BeanUtils.copyProperties(basDictForm, basDict);
		return mapping.findForward("toDictEdit");
	}
	public ActionForward doDictEdit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		BasDictForm basDictForm = (BasDictForm) form;
		BasDict basDict = new BasDict();
		BeanUtils.copyProperties(basDict,basDictForm);
		basDict.setDictUpdateDatetime(new Timestamp(System.currentTimeMillis()));
		System.out.println(basDict);
		basDictService.addOrUpdateBasDict(basDict);
		return new ActionForward("/basDictAction.do?method=toBasDictList");
	}
	public ActionForward Typename(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//List strArrayList=basDictService.custList();
		List strArrayList=basDictService.Select2();
		System.out.println(strArrayList.size());
		
		request.setAttribute("strArrayList",strArrayList);
		return mapping.findForward("Beyong");
	}
	public ActionForward toDelete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		return new ActionForward("/basDictAction.do?method=toBasDictList");
	}
}
