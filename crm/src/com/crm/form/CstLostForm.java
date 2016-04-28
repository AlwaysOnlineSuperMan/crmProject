package com.crm.form;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.crm.entity.CstLost;

/**
 * CstLost entity. @author MyEclipse Persistence Tools
 */

public class CstLostForm extends ActionForm implements java.io.Serializable {

	// Fields

	private Long lstId;
	private CstCustomerForm cstCustomer;
	private String lstCustName;
	private Long lstCustManagerId;
	private String lstCustManagerName;
	private Timestamp lstLastOrderDate;
	private Timestamp lstLostDate;
	private String lstDelay;
	private String lstReason;
	private String lstStatus;
	private Timestamp lstUpdateDatetime;

	List<CstLost> cstLostObjectList = new  ArrayList<CstLost>();
	// Property accessors



	public List<CstLost> getCstLostObjectList() {
		return cstLostObjectList;
	}

	public void setCstLostObjectList(List<CstLost> cstLostObjectList) {
		this.cstLostObjectList = cstLostObjectList;
	}

	public Long getLstId() {
		return this.lstId;
	}

	public void setLstId(Long lstId) {
		this.lstId = lstId;
	}

	public CstCustomerForm getCstCustomer() {
		return this.cstCustomer;
	}

	public void setCstCustomer(CstCustomerForm cstCustomer) {
		this.cstCustomer = cstCustomer;
	}

	public String getLstCustName() {
		return this.lstCustName;
	}

	public void setLstCustName(String lstCustName) {
		this.lstCustName = lstCustName;
	}

	public Long getLstCustManagerId() {
		return this.lstCustManagerId;
	}

	public void setLstCustManagerId(Long lstCustManagerId) {
		this.lstCustManagerId = lstCustManagerId;
	}

	public String getLstCustManagerName() {
		return this.lstCustManagerName;
	}

	public void setLstCustManagerName(String lstCustManagerName) {
		this.lstCustManagerName = lstCustManagerName;
	}

	public Timestamp getLstLastOrderDate() {
		return this.lstLastOrderDate;
	}

	public void setLstLastOrderDate(Timestamp lstLastOrderDate) {
		this.lstLastOrderDate = lstLastOrderDate;
	}

	public Timestamp getLstLostDate() {
		return this.lstLostDate;
	}

	public void setLstLostDate(Timestamp lstLostDate) {
		this.lstLostDate = lstLostDate;
	}

	public String getLstDelay() {
		return this.lstDelay;
	}

	public void setLstDelay(String lstDelay) {
		this.lstDelay = lstDelay;
	}

	public String getLstReason() {
		return this.lstReason;
	}

	public void setLstReason(String lstReason) {
		this.lstReason = lstReason;
	}

	public String getLstStatus() {
		return this.lstStatus;
	}

	public void setLstStatus(String lstStatus) {
		this.lstStatus = lstStatus;
	}

	public Timestamp getLstUpdateDatetime() {
		return this.lstUpdateDatetime;
	}

	public void setLstUpdateDatetime(Timestamp lstUpdateDatetime) {
		this.lstUpdateDatetime = lstUpdateDatetime;
	}

}