package com.crm.entity;

import java.sql.Timestamp;

/**
 * CstLinkman entity. @author MyEclipse Persistence Tools
 */

public class CstLinkman implements java.io.Serializable {

	// Fields

	private Long lkmId;
	private CstCustomer cstCustomer;
	private String lkmCustName;
	private String lkmName;
	private String lkmSex;
	private String lkmPostion;
	private String lkmTel;
	private String lkmMobile;
	private String lkmMemo;
	private Timestamp lkmUpdateDatetime;

	// Constructors

	
	
	/** default constructor */
	public CstLinkman() {
	}

	
	
	@Override
	public String toString() {
		return "CstLinkman [lkmCustName=" + lkmCustName + ", lkmId=" + lkmId
				+ ", lkmMemo=" + lkmMemo + ", lkmMobile=" + lkmMobile
				+ ", lkmName=" + lkmName + ", lkmPostion=" + lkmPostion
				+ ", lkmSex=" + lkmSex + ", lkmTel=" + lkmTel
				+ ", lkmUpdateDatetime=" + lkmUpdateDatetime + "]";
	}



	/** minimal constructor */
	public CstLinkman(CstCustomer cstCustomer, String lkmName, String lkmTel) {
		this.cstCustomer = cstCustomer;
		this.lkmName = lkmName;
		this.lkmTel = lkmTel;
	}

	/** full constructor */
	public CstLinkman(CstCustomer cstCustomer, String lkmCustName,
			String lkmName, String lkmSex, String lkmPostion, String lkmTel,
			String lkmMobile, String lkmMemo, Timestamp lkmUpdateDatetime) {
		this.cstCustomer = cstCustomer;
		this.lkmCustName = lkmCustName;
		this.lkmName = lkmName;
		this.lkmSex = lkmSex;
		this.lkmPostion = lkmPostion;
		this.lkmTel = lkmTel;
		this.lkmMobile = lkmMobile;
		this.lkmMemo = lkmMemo;
		this.lkmUpdateDatetime = lkmUpdateDatetime;
	}

	// Property accessors

	public Long getLkmId() {
		return this.lkmId;
	}

	public void setLkmId(Long lkmId) {
		this.lkmId = lkmId;
	}

	public CstCustomer getCstCustomer() {
		return this.cstCustomer;
	}

	public void setCstCustomer(CstCustomer cstCustomer) {
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