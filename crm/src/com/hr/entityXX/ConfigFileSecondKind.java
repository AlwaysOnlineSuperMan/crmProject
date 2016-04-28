package com.hr.entityXX;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ConfigFileSecondKind entity. @author MyEclipse Persistence Tools
 */

public class ConfigFileSecondKind implements java.io.Serializable {

	// Fields

	private Short fskId;
	private ConfigFileFirstKind configFileFirstKind;
	private String firstKindName;
	private String secondKindId;
	private String secondKindName;
	private String secondSalaryId;
	private String secondSaleId;
	private Date updateDateTime;
	private Set configFileThirdKinds = new HashSet(0);

	// Constructors

	/** default constructor */
	public ConfigFileSecondKind() {
	}

	/** full constructor */
	public ConfigFileSecondKind(ConfigFileFirstKind configFileFirstKind,
			String firstKindName, String secondKindId, String secondKindName,
			String secondSalaryId, String secondSaleId, Date updateDateTime,
			Set configFileThirdKinds) {
		this.configFileFirstKind = configFileFirstKind;
		this.firstKindName = firstKindName;
		this.secondKindId = secondKindId;
		this.secondKindName = secondKindName;
		this.secondSalaryId = secondSalaryId;
		this.secondSaleId = secondSaleId;
		this.updateDateTime = updateDateTime;
		this.configFileThirdKinds = configFileThirdKinds;
	}

	// Property accessors

	public Short getFskId() {
		return this.fskId;
	}

	public void setFskId(Short fskId) {
		this.fskId = fskId;
	}

	public ConfigFileFirstKind getConfigFileFirstKind() {
		return this.configFileFirstKind;
	}

	public void setConfigFileFirstKind(ConfigFileFirstKind configFileFirstKind) {
		this.configFileFirstKind = configFileFirstKind;
	}

	public String getFirstKindName() {
		return this.firstKindName;
	}

	public void setFirstKindName(String firstKindName) {
		this.firstKindName = firstKindName;
	}

	public String getSecondKindId() {
		return this.secondKindId;
	}

	public void setSecondKindId(String secondKindId) {
		this.secondKindId = secondKindId;
	}

	public String getSecondKindName() {
		return this.secondKindName;
	}

	public void setSecondKindName(String secondKindName) {
		this.secondKindName = secondKindName;
	}

	public String getSecondSalaryId() {
		return this.secondSalaryId;
	}

	public void setSecondSalaryId(String secondSalaryId) {
		this.secondSalaryId = secondSalaryId;
	}

	public String getSecondSaleId() {
		return this.secondSaleId;
	}

	public void setSecondSaleId(String secondSaleId) {
		this.secondSaleId = secondSaleId;
	}

	public Date getUpdateDateTime() {
		return this.updateDateTime;
	}

	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	public Set getConfigFileThirdKinds() {
		return this.configFileThirdKinds;
	}

	public void setConfigFileThirdKinds(Set configFileThirdKinds) {
		this.configFileThirdKinds = configFileThirdKinds;
	}

}