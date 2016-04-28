package com.crm.entity;

import java.sql.Timestamp;

/**
 * CstActivity entity. @author MyEclipse Persistence Tools
 */

public class CstActivity implements java.io.Serializable {

	// Fields

	private Long atvId;
	private CstCustomer cstCustomer;
	private String atvCustName;
	private Timestamp atvDate;
	private String atvPlace;
	private String atvTitle;
	private String atvDesc;
	private Timestamp atvUpdateDatetime;

	// Constructors

	/** default constructor */
	public CstActivity() {
	}

	/** minimal constructor */
	public CstActivity(Timestamp atvDate, String atvPlace, String atvTitle) {
		this.atvDate = atvDate;
		this.atvPlace = atvPlace;
		this.atvTitle = atvTitle;
	}

	/** full constructor */
	public CstActivity(CstCustomer cstCustomer, String atvCustName,
			Timestamp atvDate, String atvPlace, String atvTitle,
			String atvDesc, Timestamp atvUpdateDatetime) {
		this.cstCustomer = cstCustomer;
		this.atvCustName = atvCustName;
		this.atvDate = atvDate;
		this.atvPlace = atvPlace;
		this.atvTitle = atvTitle;
		this.atvDesc = atvDesc;
		this.atvUpdateDatetime = atvUpdateDatetime;
	}

	// Property accessors

	public Long getAtvId() {
		return this.atvId;
	}

	public void setAtvId(Long atvId) {
		this.atvId = atvId;
	}

	public CstCustomer getCstCustomer() {
		return this.cstCustomer;
	}

	public void setCstCustomer(CstCustomer cstCustomer) {
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