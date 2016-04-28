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
	
	
		
		/*��ѯ����
		 * 1,��½�˵�Ȩ��session.getAttribute("sysUserObject")!=null
		 * 2,�ͻ����� 
		 * 3,��Ҫ
		 * 4,��ϵ��
		 * 5,ÿҳ����          pageSize     
		 * 6,��ҳ/��5ҳ
		 * 
		 * */
		
		/*
		 * Ӫ������											
		"<1>���ۻ������
"		�漰�� 1,sal_chance ���ۻ����  
			    2,��������Ϣ��---dbo.sys_user		
				3,Ȩ�ޱ�sys_role��		
		
		�����ߣ�	��������	�ͻ�����
			==��dbo.sys_user --> usr_role_id		inner join Ȩ�ޱ�sys_role��role_id in(1,2)
		���ܣ�
		 һ����ѯ��									
		    1.��ʾ��Ϣ��ֻ��ʾ״̬Ϊ��δ���䡱�ģ���ҳ��ʾ
		     ==�� sal_chance --> chc_status in(1)	
		    2.��ѯ��������������ģ����ѯ��ע�����ݷ�ҳ��	
		    ==�� sal_chance --> custName ���� chcTitle ���� chcLinkman	
								
		    
		    4.ָ�ɣ���ָ���ˣ�ָ��ʱ�䣨��ʽ��YYYY-MM-dd���⣬������Ϣ��Ϊֻ�������ɲ��������ۻ���״̬��Ϊ����ָ�ɡ���									
		    5.�޸ģ����ԶԻ�����Դ���ͻ����ơ��ɹ����ʡ���Ҫ����ϵ�ˡ���ϵ�˵绰�������������б༭����ʱ�ı�ţ�ָ�ɶ�����ָ��ʱ����ǲ��ɲ�����									
		    6.ɾ������Ҫ�жϵ�ǰ��¼�û�Ϊ�����ۻ���Ĵ����ˣ����򲻿�ɾ������ʾ�û����Ƿ�ȷ��ɾ�����ͻ�ѡ���ǡ��ſɽ���ɾ��									
		    7.���棺��ʾ������ɹ������򱨸���Ӧ����ҳ�������δ��ʱ�������ύ�������������ݿ⣬��ת����ʾȫ��ҳ�档									
		 */
		//ÿҳpageSize��
		SalChanceForm salChanceForm = (SalChanceForm) form;
		int pageSize = 5;
		if (salChanceForm.getPageSize()>0) {
			pageSize=salChanceForm.getPageSize();
		}
		//��ҳ��Ϣ
		int transmitPage=1;//Ĭ����1
		if(request.getParameter("page") != null) {
			transmitPage = Integer.parseInt(request.getParameter("page"));
		}
		if (salChanceForm.getTransmitPage()>0) {
			transmitPage = salChanceForm.getTransmitPage();
		}
		//����ǰҳ����Ϣ���浽request��
		request.setAttribute("curPage", transmitPage);
		HttpSession session =	request.getSession();
		//����һ �� ��½�ߵ�Ȩ��ID
		Long  userRoleID =null;
		//��½�ߵ�ID
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
		String isChcStatus = "true";//trueû��ָ��
			List<SalChance> salPlansObjectList = salChanceService.getFindPropertySalChanceList(custName, chcTitle, chcLinkman, pageSize, transmitPage, userRoleID,usrID,isChcStatus);
			Long salPlansObjctCount = salChanceService.getFindPropertySalChanceCount(custName, chcTitle, chcLinkman, pageSize, transmitPage, userRoleID,usrID,isChcStatus);
		
			request.setAttribute("count", salPlansObjctCount);
		//salChanceForm.setSalPlans((Set) salPlansObjectList);
		request.setAttribute("salPlansObjectList", salPlansObjectList);
		//���ҳ��
		int totalPage =  (int) ((salPlansObjctCount % pageSize == 0) ?salPlansObjctCount / pageSize : salPlansObjctCount / pageSize+1);
		request.setAttribute("totalPage", totalPage);		
		
		return mapping.findForward("list");
	}
	
	
	public ActionForward toSalPlanAdd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
/*		 �����½���
		    3.�½����ۻ��᣺
		             �Դ����κ�ʱ����а󶨣�
		              ������ֻ���ǵ�ǰ��¼�ˣ�
		              ʱ��Ϊ��ǰʱ�䣬
		              ����������ģ�
		           ��ʱ��ָ�ɶ�����ָ��ʱ����ǲ��ɲ����ġ�
		    */		
		SalChanceForm salChanceForm = (SalChanceForm) form;
		HttpSession session =	request.getSession();
		
		//��½�ߵ�ID
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
	
	
	
	/*"<2>�ͻ������ƻ���
	"										
		�����ߣ�	�ͻ�����								
		�漰��	sal_chance ���ۻ��ᣬ sal_plan ���ۼƻ�								
		���ܣ�									
		    1.��ʾ��Ϣ��ֻ��ʾ״̬Ϊ���ѷ��䡱�����ۻ��ᣬ��ҳ��ʾ									
		    2.��ѯ��������������ģ����ѯ��ע�����ݷ�ҳ��									
		    3.�ƶ������ƻ�����ʾ�����ۻ������ϸ��Ϣ��Ҳ�ɱ༭�Ѿ��еļƻ��ɾ�����޸ģ������ڲ����Ա༭���ύ�����µ�ǰҳ��ʱ�ڼƻ����б�����ʾ�½��ļƻ���									
		    4.ִ�мƻ�����ÿ���ƻ�����дִ��Ч���������档									
		    5.�����ɹ������޸����ۻ����״̬Ϊ�������ɹ��������������ۻ�������Ӧ��Ϣ�Զ������ͻ���¼����cst_customer �ͻ�������������ת����ʾȫ��ҳ�档									
		    6.��ֹ�������޸����ۻ����״̬Ϊ������ʧ�ܡ�����ת����ʾȫ��ҳ�档									
		    7.���棺��ʾ������ɹ������򱨸���Ӧ����ҳ�������δ��ʱ�������ύ�������������ݿ⣬��ת����ʾȫ��ҳ�档									
*/
	public ActionForward salChanceList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//ÿҳpageSize��
		SalChanceForm salChanceForm = (SalChanceForm) form;
		int pageSize = 5;
		if (salChanceForm.getPageSize()>0) {
			pageSize=salChanceForm.getPageSize();
		}
		//��ҳ��Ϣ
		int transmitPage=1;//Ĭ����1
		if(request.getParameter("page") != null) {
			transmitPage = Integer.parseInt(request.getParameter("page"));
		}
		if (salChanceForm.getTransmitPage()>0) {
			transmitPage = salChanceForm.getTransmitPage();
		}
		//����ǰҳ����Ϣ���浽request��
		request.setAttribute("curPage", transmitPage);
		HttpSession session =	request.getSession();
		//����һ �� ��½�ߵ�Ȩ��ID
		Long  userRoleID =null;
		//��½�ߵ�ID
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
		String isChcStatus = "false";//û��ָ��
			List<SalChance> salPlansObjectList = salChanceService.getFindPropertySalChanceList(custName, chcTitle, chcLinkman, pageSize, transmitPage, userRoleID,usrID,isChcStatus);
			Long salPlansObjctCount = salChanceService.getFindPropertySalChanceCount(custName, chcTitle, chcLinkman, pageSize, transmitPage, userRoleID,usrID,isChcStatus);
			request.setAttribute("count", salPlansObjctCount);
		//salChanceForm.setSalPlans((Set) salPlansObjectList);
		request.setAttribute("salPlansObjectList", salPlansObjectList);
		//���ҳ��
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