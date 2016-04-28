package com.crm.entity;

import java.sql.Timestamp;

/**
 * CstLost entity. @author MyEclipse Persistence Tools
 */

public class CstLost implements java.io.Serializable {

	// Fields

	private Long lstId;
	private CstCustomer cstCustomer = new CstCustomer();;
	private String lstCustName;
	private Long lstCustManagerId;
	private String lstCustManagerName;
	private Timestamp lstLastOrderDate;
	private Timestamp lstLostDate;
	private String lstDelay;
	private String lstReason;
	private String lstStatus;
	private Timestamp lstUpdateDatetime;

	// Constructors

	/** default constructor */
	public CstLost() {
	}

	/** minimal constructor */
	public CstLost(CstCustomer cstCustomer, Long lstCustManagerId,
			String lstCustManagerName, String lstStatus) {
		this.cstCustomer = cstCustomer;
		this.lstCustManagerId = lstCustManagerId;
		this.lstCustManagerName = lstCustManagerName;
		this.lstStatus = lstStatus;
	}

	/** full constructor */
	public CstLost(CstCustomer cstCustomer, String lstCustName,
			Long lstCustManagerId, String lstCustManagerName,
			Timestamp lstLastOrderDate, Timestamp lstLostDate, String lstDelay,
			String lstReason, String lstStatus, Timestamp lstUpdateDatetime) {
		this.cstCustomer = cstCustomer;
		this.lstCustName = lstCustName;
		this.lstCustManagerId = lstCustManagerId;
		this.lstCustManagerName = lstCustManagerName;
		this.lstLastOrderDate = lstLastOrderDate;
		this.lstLostDate = lstLostDate;
		this.lstDelay = lstDelay;
		this.lstReason = lstReason;
		this.lstStatus = lstStatus;
		this.lstUpdateDatetime = lstUpdateDatetime;
	}

	// Property accessors

	public Long getLstId() {
		return this.lstId;
	}

	public void setLstId(Long lstId) {
		this.lstId = lstId;
	}

	public CstCustomer getCstCustomer() {
		return this.cstCustomer;
	}

	public void setCstCustomer(CstCustomer cstCustomer) {
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