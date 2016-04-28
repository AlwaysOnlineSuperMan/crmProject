package com.hr.entityXX;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ConfigFileFirstKind entity. @author MyEclipse Persistence Tools
 */

public class ConfigFileFirstKind implements java.io.Serializable {

	// Fields

	private Short ffkId;
	private String firstKindId;
	private String firstKindName;
	private String firstKindSalaryId;
	private String firstKindSaleId;
	private Date updateDateTime;
	private Set configFileSecondKinds = new HashSet(0);

	// Constructors

	/** default constructor */
	public ConfigFileFirstKind() {
	}

	/** full constructor */
	public ConfigFileFirstKind(String firstKindId, String firstKindName,
			String firstKindSalaryId, String firstKindSaleId,
			Date updateDateTime, Set configFileSecondKinds) {
		this.firstKindId = firstKindId;
		this.firstKindName = firstKindName;
		this.firstKindSalaryId = firstKindSalaryId;
		this.firstKindSaleId = firstKindSaleId;
		this.updateDateTime = updateDateTime;
		this.configFileSecondKinds = configFileSecondKinds;
	}

	// Property accessors

	public Short getFfkId() {
		return this.ffkId;
	}

	public void setFfkId(Short ffkId) {
		this.ffkId = ffkId;
	}

	public String getFirstKindId() {
		return this.firstKindId;
	}

	public void setFirstKindId(String firstKindId) {
		this.firstKindId = firstKindId;
	}

	public String getFirstKindName() {
		return this.firstKindName;
	}

	public void setFirstKindName(String firstKindName) {
		this.firstKindName = firstKindName;
	}

	public String getFirstKindSalaryId() {
		return this.firstKindSalaryId;
	}

	public void setFirstKindSalaryId(String firstKindSalaryId) {
		this.firstKindSalaryId = firstKindSalaryId;
	}

	public String getFirstKindSaleId() {
		return this.firstKindSaleId;
	}

	public void setFirstKindSaleId(String firstKindSaleId) {
		this.firstKindSaleId = firstKindSaleId;
	}

	public Date getUpdateDateTime() {
		return this.updateDateTime;
	}

	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	public Set getConfigFileSecondKinds() {
		return this.configFileSecondKinds;
	}

	public void setConfigFileSecondKinds(Set configFileSecondKinds) {
		this.configFileSecondKinds = configFileSecondKinds;
	}

}