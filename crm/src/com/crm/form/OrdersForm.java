package com.crm.form;

import java.sql.Timestamp;

import org.apache.struts.action.ActionForm;

/**
 * Orders entity. @author MyEclipse Persistence Tools
 */

public class OrdersForm extends ActionForm implements java.io.Serializable {

	// Fields

	private Long odrId;
	private String odrCustomer;
	private Timestamp odrDate;
	private String odrAddr;
	private String odrStatus;
	private Timestamp odrUpdateDatetime;

	
	// Property accessors

	public Long getOdrId() {
		return this.odrId;
	}

	public void setOdrId(Long odrId) {
		this.odrId = odrId;
	}

	public String getOdrCustomer() {
		return this.odrCustomer;
	}

	public void setOdrCustomer(String odrCustomer) {
		this.odrCustomer = odrCustomer;
	}

	public Timestamp getOdrDate() {
		return this.odrDate;
	}

	public void setOdrDate(Timestamp odrDate) {
		this.odrDate = odrDate;
	}

	public String getOdrAddr() {
		return this.odrAddr;
	}

	public void setOdrAddr(String odrAddr) {
		this.odrAddr = odrAddr;
	}

	public String getOdrStatus() {
		return this.odrStatus;
	}

	public void setOdrStatus(String odrStatus) {
		this.odrStatus = odrStatus;
	}

	public Timestamp getOdrUpdateDatetime() {
		return this.odrUpdateDatetime;
	}

	public void setOdrUpdateDatetime(Timestamp odrUpdateDatetime) {
		this.odrUpdateDatetime = odrUpdateDatetime;
	}

}