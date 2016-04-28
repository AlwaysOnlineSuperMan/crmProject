package com.crm.entity;

import java.sql.Timestamp;

/**
 * Storage entity. @author MyEclipse Persistence Tools
 */

public class Storage implements java.io.Serializable {

	// Fields

	private Long stkId;
	private Long stkProdId;
	private String stkWarehouse;
	private String stkWare;
	private Integer stkCount;
	private String stkMemo;
	private Timestamp stkUpdateDatetime;
	private String stkProductName;
	// Constructors

	public String getStkProductName() {
		return stkProductName;
	}

	public void setStkProductName(String stkProductName) {
		this.stkProductName = stkProductName;
	}

	/** default constructor */
	public Storage() {
	}

	/** minimal constructor */
	public Storage(Long stkProdId, String stkWarehouse, String stkWare,
			Integer stkCount) {
		this.stkProdId = stkProdId;
		this.stkWarehouse = stkWarehouse;
		this.stkWare = stkWare;
		this.stkCount = stkCount;
	}

	/** full constructor */
	public Storage(Long stkProdId, String stkWarehouse, String stkWare,
			Integer stkCount, String stkMemo, Timestamp stkUpdateDatetime) {
		this.stkProdId = stkProdId;
		this.stkWarehouse = stkWarehouse;
		this.stkWare = stkWare;
		this.stkCount = stkCount;
		this.stkMemo = stkMemo;
		this.stkUpdateDatetime = stkUpdateDatetime;
	}

	// Property accessors

	public Long getStkId() {
		return this.stkId;
	}

	public void setStkId(Long stkId) {
		this.stkId = stkId;
	}

	public Long getStkProdId() {
		return this.stkProdId;
	}

	public void setStkProdId(Long stkProdId) {
		this.stkProdId = stkProdId;
	}

	public String getStkWarehouse() {
		return this.stkWarehouse;
	}

	public void setStkWarehouse(String stkWarehouse) {
		this.stkWarehouse = stkWarehouse;
	}

	public String getStkWare() {
		return this.stkWare;
	}

	public void setStkWare(String stkWare) {
		this.stkWare = stkWare;
	}

	public Integer getStkCount() {
		return this.stkCount;
	}

	public void setStkCount(Integer stkCount) {
		this.stkCount = stkCount;
	}

	public String getStkMemo() {
		return this.stkMemo;
	}

	public void setStkMemo(String stkMemo) {
		this.stkMemo = stkMemo;
	}

	public Timestamp getStkUpdateDatetime() {
		return this.stkUpdateDatetime;
	}

	public void setStkUpdateDatetime(Timestamp stkUpdateDatetime) {
		this.stkUpdateDatetime = stkUpdateDatetime;
	}

}