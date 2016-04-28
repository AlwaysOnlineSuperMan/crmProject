package com.hr.entityXX;

import java.util.Date;

/**
 * SalaryGrantDetails entity. @author MyEclipse Persistence Tools
 */

public class SalaryGrantDetails implements java.io.Serializable {

	// Fields

	private Short grdId;
	private String salaryGrantId;
	private String humanId;
	private String humanName;
	private Float bounsSum;
	private Float saleSum;
	private Float deductSum;
	private Float salaryStandardSum;
	private Float salaryPaidSum;
	private Date updateDateTime;

	// Constructors

	/** default constructor */
	public SalaryGrantDetails() {
	}

	/** full constructor */
	public SalaryGrantDetails(String salaryGrantId, String humanId,
			String humanName, Float bounsSum, Float saleSum, Float deductSum,
			Float salaryStandardSum, Float salaryPaidSum, Date updateDateTime) {
		this.salaryGrantId = salaryGrantId;
		this.humanId = humanId;
		this.humanName = humanName;
		this.bounsSum = bounsSum;
		this.saleSum = saleSum;
		this.deductSum = deductSum;
		this.salaryStandardSum = salaryStandardSum;
		this.salaryPaidSum = salaryPaidSum;
		this.updateDateTime = updateDateTime;
	}

	// Property accessors

	public Short getGrdId() {
		return this.grdId;
	}

	public void setGrdId(Short grdId) {
		this.grdId = grdId;
	}

	public String getSalaryGrantId() {
		return this.salaryGrantId;
	}

	public void setSalaryGrantId(String salaryGrantId) {
		this.salaryGrantId = salaryGrantId;
	}

	public String getHumanId() {
		return this.humanId;
	}

	public void setHumanId(String humanId) {
		this.humanId = humanId;
	}

	public String getHumanName() {
		return this.humanName;
	}

	public void setHumanName(String humanName) {
		this.humanName = humanName;
	}

	public Float getBounsSum() {
		return this.bounsSum;
	}

	public void setBounsSum(Float bounsSum) {
		this.bounsSum = bounsSum;
	}

	public Float getSaleSum() {
		return this.saleSum;
	}

	public void setSaleSum(Float saleSum) {
		this.saleSum = saleSum;
	}

	public Float getDeductSum() {
		return this.deductSum;
	}

	public void setDeductSum(Float deductSum) {
		this.deductSum = deductSum;
	}

	public Float getSalaryStandardSum() {
		return this.salaryStandardSum;
	}

	public void setSalaryStandardSum(Float salaryStandardSum) {
		this.salaryStandardSum = salaryStandardSum;
	}

	public Float getSalaryPaidSum() {
		return this.salaryPaidSum;
	}

	public void setSalaryPaidSum(Float salaryPaidSum) {
		this.salaryPaidSum = salaryPaidSum;
	}

	public Date getUpdateDateTime() {
		return this.updateDateTime;
	}

	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

}