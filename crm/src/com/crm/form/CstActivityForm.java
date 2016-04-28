package com.crm.form;

import java.sql.Timestamp;

import org.apache.struts.action.ActionForm;

/**
 * CstActivity entity. @author MyEclipse Persistence Tools
 */

public class CstActivityForm extends ActionForm implements java.io.Serializable {

	// Fields

	private Long atvId;
	private CstCustomerForm cstCustomer;
	private String atvCustName;
	private Timestamp atvDate;
	private String atvPlace;
	private String atvTitle;
	private String atvDesc;
	private Timestamp atvUpdateDatetime;

	// Property accessors

	public Long getAtvId() {
		return this.atvId;
	}

	public void setAtvId(Long atvId) {
		this.atvId = atvId;
	}

	public CstCustomerForm getCstCustomer() {
		return this.cstCustomer;
	}

	public void setCstCustomer(CstCustomerForm cstCustomer) {
		this.cstCustomer = cstCustomer;
	}

	public String getAtvCustName() {
		return this.atvCustName;
	}

	public void setAtvCustName(String atvCustName) {
		this.atvCustName = atvCustName;
	}

	public Timestamp getAtvDate() {
		return this.atvDate;
	}

	public void setAtvDate(Timestamp atvDate) {
		this.atvDate = atvDate;
	}

	public String getAtvPlace() {
		return this.atvPlace;
	}

	public void setAtvPlace(String atvPlace) {
		this.atvPlace = atvPlace;
	}

	public String getAtvTitle() {
		return this.atvTitle;
	}

	public void setAtvTitle(String atvTitle) {
		this.atvTitle = atvTitle;
	}

	public String getAtvDesc() {
		return this.atvDesc;
	}

	public void setAtvDesc(String atvDesc) {
		this.atvDesc = atvDesc;
	}

	public Timestamp getAtvUpdateDatetime() {
		return this.atvUpdateDatetime;
	}

	public void setAtvUpdateDatetime(Timestamp atvUpdateDatetime) {
		this.atvUpdateDatetime = atvUpdateDatetime;
	}

}