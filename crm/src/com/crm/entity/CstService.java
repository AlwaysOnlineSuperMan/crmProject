package com.crm.entity;

import java.sql.Timestamp;

/**
 * CstService entity. @author MyEclipse Persistence Tools
 */

public class CstService implements java.io.Serializable {

	// Fields

	private Long svrId;
	private CstCustomer cstCustomer;
	private String svrType;
	private String svrTitle;
	private String svrCustNo;
	private String svrCustName;
	private String svrStatus;
	private String svrRequest;
	private Long svrCreateId;
	private String svrCreateBy;
	private Timestamp svrCreateDate;
	private Long svrDueId;
	private String svrDueTo;
	private Timestamp svrDueDate;
	private String svrDeal;
	private Long svrDealId;
	private String svrDealBy;
	private Timestamp svrDealDate;
	private String svrResult;
	private Integer svrSatisfy;
	private String svrUpdateDatetime;

	// Constructors

	@Override
	public String toString() {
		return "CstService [cstCustomer=" + cstCustomer + ", svrCreateBy="
				+ svrCreateBy + ", svrCreateDate=" + svrCreateDate
				+ ", svrCreateId=" + svrCreateId + ", svrCustName="
				+ svrCustName + ", svrCustNo=" + svrCustNo + ", svrDeal="
				+ svrDeal + ", svrDealBy=" + svrDealBy + ", svrDealDate="
				+ svrDealDate + ", svrDealId=" + svrDealId + ", svrDueDate="
				+ svrDueDate + ", svrDueId=" + svrDueId + ", svrDueTo="
				+ svrDueTo + ", svrId=" + svrId + ", svrRequest=" + svrRequest
				+ ", svrResult=" + svrResult + ", svrSatisfy=" + svrSatisfy
				+ ", svrStatus=" + svrStatus + ", svrTitle=" + svrTitle
				+ ", svrType=" + svrType + ", svrUpdateDatetime="
				+ svrUpdateDatetime + "]";
	}

	/** default constructor */
	public CstService() {
	}

	/** minimal constructor */
	public CstService(String svrType, String svrTitle, String svrCustName,
			String svrStatus, String svrRequest, Long svrCreateId,
			String svrCreateBy, Timestamp svrCreateDate) {
		this.svrType = svrType;
		this.svrTitle = svrTitle;
		this.svrCustName = svrCustName;
		this.svrStatus = svrStatus;
		this.svrRequest = svrRequest;
		this.svrCreateId = svrCreateId;
		this.svrCreateBy = svrCreateBy;
		this.svrCreateDate = svrCreateDate;
	}

	/** full constructor */
	public CstService(CstCustomer cstCustomer, String svrType, String svrTitle,
			String svrCustName, String svrStatus, String svrRequest,
			Long svrCreateId, String svrCreateBy, Timestamp svrCreateDate,
			Long svrDueId, String svrDueTo, Timestamp svrDueDate,
			String svrDeal, Long svrDealId, String svrDealBy,
			Timestamp svrDealDate, String svrResult, Integer svrSatisfy,
			String svrUpdateDatetime) {
		this.cstCustomer = cstCustomer;
		this.svrType = svrType;
		this.svrTitle = svrTitle;
		this.svrCustName = svrCustName;
		this.svrStatus = svrStatus;
		this.svrRequest = svrRequest;
		this.svrCreateId = svrCreateId;
		this.svrCreateBy = svrCreateBy;
		this.svrCreateDate = svrCreateDate;
		this.svrDueId = svrDueId;
		this.svrDueTo = svrDueTo;
		this.svrDueDate = svrDueDate;
		this.svrDeal = svrDeal;
		this.svrDealId = svrDealId;
		this.svrDealBy = svrDealBy;
		this.svrDealDate = svrDealDate;
		this.svrResult = svrResult;
		this.svrSatisfy = svrSatisfy;
		this.svrUpdateDatetime = svrUpdateDatetime;
	}

	// Property accessors

	public Long getSvrId() {
		return this.svrId;
	}

	public void setSvrId(Long svrId) {
		this.svrId = svrId;
	}

	public CstCustomer getCstCustomer() {
		return this.cstCustomer;
	}

	public void setCstCustomer(CstCustomer cstCustomer) {
		this.cstCustomer = cstCustomer;
	}

	public String getSvrType() {
		return this.svrType;
	}

	public void setSvrType(String svrType) {
		this.svrType = svrType;
	}

	public String getSvrTitle() {
		return this.svrTitle;
	}

	public void setSvrTitle(String svrTitle) {
		this.svrTitle = svrTitle;
	}

	public String getSvrCustName() {
		return this.svrCustName;
	}

	public void setSvrCustName(String svrCustName) {
		this.svrCustName = svrCustName;
	}

	public String getSvrStatus() {
		return this.svrStatus;
	}

	public void setSvrStatus(String svrStatus) {
		this.svrStatus = svrStatus;
	}

	public String getSvrRequest() {
		return this.svrRequest;
	}

	public void setSvrRequest(String svrRequest) {
		this.svrRequest = svrRequest;
	}

	public Long getSvrCreateId() {
		return this.svrCreateId;
	}

	public void setSvrCreateId(Long svrCreateId) {
		this.svrCreateId = svrCreateId;
	}

	public String getSvrCreateBy() {
		return this.svrCreateBy;
	}

	public void setSvrCreateBy(String svrCreateBy) {
		this.svrCreateBy = svrCreateBy;
	}

	public Timestamp getSvrCreateDate() {
		return this.svrCreateDate;
	}

	public void setSvrCreateDate(Timestamp svrCreateDate) {
		this.svrCreateDate = svrCreateDate;
	}

	public Long getSvrDueId() {
		return this.svrDueId;
	}

	public void setSvrDueId(Long svrDueId) {
		this.svrDueId = svrDueId;
	}

	public String getSvrDueTo() {
		return this.svrDueTo;
	}

	public void setSvrDueTo(String svrDueTo) {
		this.svrDueTo = svrDueTo;
	}

	public Timestamp getSvrDueDate() {
		return this.svrDueDate;
	}

	public void setSvrDueDate(Timestamp svrDueDate) {
		this.svrDueDate = svrDueDate;
	}

	public String getSvrDeal() {
		return this.svrDeal;
	}

	public void setSvrDeal(String svrDeal) {
		this.svrDeal = svrDeal;
	}

	public Long getSvrDealId() {
		return this.svrDealId;
	}

	public void setSvrDealId(Long svrDealId) {
		this.svrDealId = svrDealId;
	}

	public String getSvrDealBy() {
		return this.svrDealBy;
	}

	public void setSvrDealBy(String svrDealBy) {
		this.svrDealBy = svrDealBy;
	}

	public Timestamp getSvrDealDate() {
		return this.svrDealDate;
	}

	public void setSvrDealDate(Timestamp svrDealDate) {
		this.svrDealDate = svrDealDate;
	}

	public String getSvrResult() {
		return this.svrResult;
	}

	public void setSvrResult(String svrResult) {
		this.svrResult = svrResult;
	}

	public Integer getSvrSatisfy() {
		return this.svrSatisfy;
	}

	public void setSvrSatisfy(Integer svrSatisfy) {
		this.svrSatisfy = svrSatisfy;
	}

	public String getSvrUpdateDatetime() {
		return this.svrUpdateDatetime;
	}

	public void setSvrUpdateDatetime(String svrUpdateDatetime) {
		this.svrUpdateDatetime = svrUpdateDatetime;
	}

	public void setSvrCustNo(String svrCustNo) {
		this.svrCustNo = svrCustNo;
	}

	public String getSvrCustNo() {
		return svrCustNo;
	}
}