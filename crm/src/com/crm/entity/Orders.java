package com.crm.entity;

import java.sql.Timestamp;

/**
 * Orders entity. @author MyEclipse Persistence Tools
 */

public class Orders implements java.io.Serializable {

	// Fields

	private Long odrId;
	private String odrCustomer;
	private Timestamp odrDate;
	private String odrAddr;
	private String odrStatus;
	private Timestamp odrUpdateDatetime;

	// Constructors

	/** default constructor */
	public Orders() {
	}

	/** minimal constructor */
	public Orders(String odrCustomer, Timestamp odrDate, String odrStatus) {
		this.odrCustomer = odrCustomer;
		this.odrDate = odrDate;
		this.odrStatus = odrStatus;
	}

	/** full constructor */
	public Orders(String odrCustomer, Timestamp odrDate, String odrAddr,
			String odrStatus, Timestamp odrUpdateDatetime) {
		this.odrCustomer = odrCustomer;
		this.odrDate = odrDate;
		this.odrAddr = odrAddr;
		this.odrStatus = odrStatus;
		this.odrUpdateDatetime = odrUpdateDatetime;
	}

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