package com.crm.form;

import java.sql.Timestamp;

import org.apache.struts.action.ActionForm;

/**
 * CstLinkman entity. @author MyEclipse Persistence Tools
 */

public class CstLinkmanForm extends ActionForm implements java.io.Serializable {

	// Fields

	private Long lkmId;
	private CstCustomerForm cstCustomer = new CstCustomerForm();
	private String lkmCustName;
	private String lkmName;
	private String lkmSex;
	private String lkmPostion;
	private String lkmTel;
	private String lkmMobile;
	private String lkmMemo;
	private Timestamp lkmUpdateDatetime;


	// Property accessors

	public Long getLkmId() {
		return this.lkmId;
	}

	public void setLkmId(Long lkmId) {
		this.lkmId = lkmId;
	}

	public CstCustomerForm getCstCustomer() {
		return this.cstCustomer;
	}

	public void setCstCustomer(CstCustomerForm cstCustomer) {
		this.cstCustomer = cstCustomer;
	}

	public String getLkmCustName() {
		return this.lkmCustName;
	}

	public void setLkmCustName(String lkmCustName) {
		this.lkmCustName = lkmCustName;
	}

	public String getLkmName() {
		return this.lkmName;
	}

	public void setLkmName(String lkmName) {
		this.lkmName = lkmName;
	}

	public String getLkmSex() {
		return this.lkmSex;
	}

	public void setLkmSex(String lkmSex) {
		this.lkmSex = lkmSex;
	}

	public String getLkmPostion() {
		return this.lkmPostion;
	}

	public void setLkmPostion(String lkmPostion) {
		this.lkmPostion = lkmPostion;
	}

	public String getLkmTel() {
		return this.lkmTel;
	}

	public void setLkmTel(String lkmTel) {
		this.lkmTel = lkmTel;
	}

	public String getLkmMobile() {
		return this.lkmMobile;
	}

	public void setLkmMobile(String lkmMobile) {
		this.lkmMobile = lkmMobile;
	}

	public String getLkmMemo() {
		return this.lkmMemo;
	}

	public void setLkmMemo(String lkmMemo) {
		this.lkmMemo = lkmMemo;
	}

	public Timestamp getLkmUpdateDatetime() {
		return this.lkmUpdateDatetime;
	}

	public void setLkmUpdateDatetime(Timestamp lkmUpdateDatetime) {
		this.lkmUpdateDatetime = lkmUpdateDatetime;
	}

}