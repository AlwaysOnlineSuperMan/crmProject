package com.crm.form;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.crm.entity.SysRole;
import com.crm.entity.SysUser;
import com.crm.util.AppException;
import com.crm.util.PageModel;
import com.crm.util.ResourcesInit;

/**
 * SysUser entity. @author MyEclipse Persistence Tools
 */

public class SysUserForm extends ActionForm implements java.io.Serializable {

	// Fields

	private Long usrId;
	private String usrNo;
	private String usrName;
	private String usrPassword;
	private Long usrRoleId;
	private String usrRoleName;
	
	private Integer usrFlag;
	private Timestamp usrUpdateDatetime;
	private String maxRecord;
	private String currPage;
	private PageModel<SysUser> pageModel= new PageModel<SysUser>();
	
	
	
	







	public PageModel<SysUser> getPageModel() {
		return pageModel;
	}







	public void setPageModel(PageModel<SysUser> pageModel) {
		this.pageModel = pageModel;
	}







	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		String method=request.getParameter("method");
		if (method.equalsIgnoreCase("login")) {
			
		
		if (usrNo.equalsIgnoreCase("")) {
			ActionMessage message = new ActionMessage("error.login",ResourcesInit.getString("sysUser.name"));
			errors.add("login.usrNo", message);
		}
		if (usrPassword.equals("")) {
			ActionMessage message = new ActionMessage("error.login",ResourcesInit.getString("sysUser.pwd"));
			errors.add("login.pwd", message);
		}
		}
		return errors;
	}
	
	
	
	
	
	
	
	public String getUsrRoleName() {
		return usrRoleName;
	}

	public void setUsrRoleName(String usrRoleName) {
		this.usrRoleName = usrRoleName;
	}
	
	private List<SysRole> sysRoleList = new ArrayList<SysRole>();
	
	public List<SysRole> getSysRoleList() {
		return sysRoleList;
	}

	public void setSysRoleList(List<SysRole> sysRoleList) {
		this.sysRoleList = sysRoleList;
	}

	
	
	// Property accessors

	public String getCurrPage() {
		return currPage;
	}

	public void setCurrPage(String currPage) {
		this.currPage = currPage;
	}

	public String getMaxRecord() {
		return maxRecord;
	}

	public void setMaxRecord(String maxRecord) {
		this.maxRecord = maxRecord;
	}

	public Long getUsrId() {
		return this.usrId;
	}

	public void setUsrId(Long usrId) {
		this.usrId = usrId;
	}

	public String getUsrNo() {
		return this.usrNo;
	}

	public void setUsrNo(String usrNo) {
		this.usrNo = usrNo;
	}

	public String getUsrName() {
		return this.usrName;
	}

	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}

	public String getUsrPassword() {
		return this.usrPassword;
	}

	public void setUsrPassword(String usrPassword) {
		this.usrPassword = usrPassword;
	}

	public Long getUsrRoleId() {
		return this.usrRoleId;
	}

	public void setUsrRoleId(Long usrRoleId) {
		this.usrRoleId = usrRoleId;
	}

	public Integer getUsrFlag() {
		return this.usrFlag;
	}

	public void setUsrFlag(Integer usrFlag) {
		this.usrFlag = usrFlag;
	}

	public Timestamp getUsrUpdateDatetime() {
		return this.usrUpdateDatetime;
	}

	public void setUsrUpdateDatetime(Timestamp usrUpdateDatetime) {
		this.usrUpdateDatetime = usrUpdateDatetime;
	}

}