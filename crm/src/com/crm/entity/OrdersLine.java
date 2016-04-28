package com.crm.entity;

import java.sql.Timestamp;

/**
 * OrdersLine entity. @author MyEclipse Persistence Tools
 */

public class OrdersLine implements java.io.Serializable {

	// Fields

	private Long oddId;
	private Long oddOrderId;
	private Long oddProdId;
	private Integer oddCount;
	private String oddUnit;
	private Double oddPrice;
	private Timestamp oddUpdateDatetime;

	// Constructors

	/** default constructor */
	public OrdersLine() {
	}

	/** minimal constructor */
	public OrdersLine(Long oddOrderId, Long oddProdId, Integer oddCount) {
		this.oddOrderId = oddOrderId;
		this.oddProdId = oddProdId;
		this.oddCount = oddCount;
	}

	/** full constructor */
	public OrdersLine(Long oddOrderId, Long oddProdId, Integer oddCount,
			String oddUnit, Double oddPrice, Timestamp oddUpdateDatetime) {
		this.oddOrderId = oddOrderId;
		this.oddProdId = oddProdId;
		this.oddCount = oddCount;
		this.oddUnit = oddUnit;
		this.oddPrice = oddPrice;
		this.oddUpdateDatetime = oddUpdateDatetime;
	}

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