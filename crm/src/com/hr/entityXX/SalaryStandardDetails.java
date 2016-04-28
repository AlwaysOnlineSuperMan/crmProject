package com.hr.entityXX;

import java.util.Date;

/**
 * SalaryStandardDetails entity. @author MyEclipse Persistence Tools
 */

public class SalaryStandardDetails implements java.io.Serializable {

	// Fields

	private Short sdtId;
	private String standardId;
	private String standardName;
	private Short itemId;
	private String itemName;
	private Float salary;
	private Date updateDateTime;

	// Constructors

	/** default constructor */
	public SalaryStandardDetails() {
	}

	/** full constructor */
	public SalaryStandardDetails(String standardId, String standardName,
			Short itemId, String itemName, Float salary, Date updateDateTime) {
		this.standardId = standardId;
		this.standardName = standardName;
		this.itemId = itemId;
		this.itemName = itemName;
		this.salary = salary;
		this.updateDateTime = updateDateTime;
	}

	// Property accessors

	public Short getSdtId() {
		return this.sdtId;
	}

	public void setSdtId(Short sdtId) {
		this.sdtId = sdtId;
	}

	public String getStandardId() {
		return this.standardId;
	}

	public void setStandardId(String standardId) {
		this.standardId = standardId;
	}

	public String getStandardName() {
		return this.standardName;
	}

	public void setStandardName(String standardName) {
		this.standardName = standardName;
	}

	public Short getItemId() {
		return this.itemId;
	}

	public void setItemId(Short itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Float getSalary() {
		return this.salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	public Date getUpdateDateTime() {
		return this.updateDateTime;
	}

	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

}