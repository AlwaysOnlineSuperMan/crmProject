package com.crm.form;

import java.sql.Timestamp;

import org.apache.struts.action.ActionForm;

/**
 * OrdersLine entity. @author MyEclipse Persistence Tools
 */

public class OrdersLineForm extends ActionForm implements java.io.Serializable {

	// Fields

	private Long oddId;
	private Long oddOrderId;
	private Long oddProdId;
	private Integer oddCount;
	private String oddUnit;
	private Double oddPrice;
	private Timestamp oddUpdateDatetime;

	
	// Property accessors

	public Long getOddId() {
		return this.oddId;
	}

	public void setOddId(Long oddId) {
		this.oddId = oddId;
	}

	public Long getOddOrderId() {
		return this.oddOrderId;
	}

	public void setOddOrderId(Long oddOrderId) {
		this.oddOrderId = oddOrderId;
	}

	public Long getOddProdId() {
		return this.oddProdId;
	}

	public void setOddProdId(Long oddProdId) {
		this.oddProdId = oddProdId;
	}

	public Integer getOddCount() {
		return this.oddCount;
	}

	public void setOddCount(Integer oddCount) {
		this.oddCount = oddCount;
	}

	public String getOddUnit() {
		return this.oddUnit;
	}

	public void setOddUnit(String oddUnit) {
		this.oddUnit = oddUnit;
	}

	public Double getOddPrice() {
		return this.oddPrice;
	}

	public void setOddPrice(Double oddPrice) {
		this.oddPrice = oddPrice;
	}

	public Timestamp getOddUpdateDatetime() {
		return this.oddUpdateDatetime;
	}

	public void setOddUpdateDatetime(Timestamp oddUpdateDatetime) {
		this.oddUpdateDatetime = oddUpdateDatetime;
	}

}