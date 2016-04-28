package com.hr.entityXX;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ConfigFileThirdKind entity. @author MyEclipse Persistence Tools
 */

public class ConfigFileThirdKind implements java.io.Serializable {

	// Fields

	private Short ftkId;
	private ConfigFileSecondKind configFileSecondKind;
	private String firstKindId;
	private String firstKindName;
	private String secondKindName;
	private String thirdKindId;
	private String thirdKindName;
	private String thirdKindSaleId;
	private String thirdKindIsRetail;
	private Date updateDateTime;
	private Set humanFileDigs = new HashSet(0);

	// Constructors

	/** default constructor */
	public ConfigFileThirdKind() {
	}

	/** full constructor */
	public ConfigFileThirdKind(ConfigFileSecondKind configFileSecondKind,
			String firstKindId, String firstKindName, String secondKindName,
			String thirdKindId, String thirdKindName, String thirdKindSaleId,
			String thirdKindIsRetail, Date updateDateTime, Set humanFileDigs) {
		this.configFileSecondKind = configFileSecondKind;
		this.firstKindId = firstKindId;
		this.firstKindName = firstKindName;
		this.secondKindName = secondKindName;
		this.thirdKindId = thirdKindId;
		this.thirdKindName = thirdKindName;
		this.thirdKindSaleId = thirdKindSaleId;
		this.thirdKindIsRetail = thirdKindIsRetail;
		this.updateDateTime = updateDateTime;
		this.humanFileDigs = humanFileDigs;
	}

	// Property accessors

	public Short getFtkId() {
		return this.ftkId;
	}

	public void setFtkId(Short ftkId) {
		this.ftkId = ftkId;
	}

	public ConfigFileSecondKind getConfigFileSecondKind() {
		return this.configFileSecondKind;
	}

	public void setConfigFileSecondKind(
			ConfigFileSecondKind configFileSecondKind) {
		this.configFileSecondKind = configFileSecondKind;
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

	public String getSecondKindName() {
		return this.secondKindName;
	}

	public void setSecondKindName(String secondKindName) {
		this.secondKindName = secondKindName;
	}

	public String getThirdKindId() {
		return this.thirdKindId;
	}

	public void setThirdKindId(String thirdKindId) {
		this.thirdKindId = thirdKindId;
	}

	public String getThirdKindName() {
		return this.thirdKindName;
	}

	public void setThirdKindName(String thirdKindName) {
		this.thirdKindName = thirdKindName;
	}

	public String getThirdKindSaleId() {
		return this.thirdKindSaleId;
	}

	public void setThirdKindSaleId(String thirdKindSaleId) {
		this.thirdKindSaleId = thirdKindSaleId;
	}

	public String getThirdKindIsRetail() {
		return this.thirdKindIsRetail;
	}

	public void setThirdKindIsRetail(String thirdKindIsRetail) {
		this.thirdKindIsRetail = thirdKindIsRetail;
	}

	public Date getUpdateDateTime() {
		return this.updateDateTime;
	}

	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	public Set getHumanFileDigs() {
		return this.humanFileDigs;
	}

	public void setHumanFileDigs(Set humanFileDigs) {
		this.humanFileDigs = humanFileDigs;
	}

}