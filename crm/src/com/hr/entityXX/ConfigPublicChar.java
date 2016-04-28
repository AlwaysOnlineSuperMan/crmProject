package com.hr.entityXX;

import java.util.Date;

/**
 * ConfigPublicChar entity. @author MyEclipse Persistence Tools
 */

public class ConfigPublicChar implements java.io.Serializable {

	// Fields

	private Short pbcId;
	private String attributeKind;
	private String attributeName;
	private Date updateDateTime;

	// Constructors

	/** default constructor */
	public ConfigPublicChar() {
	}

	/** full constructor */
	public ConfigPublicChar(String attributeKind, String attributeName,
			Date updateDateTime) {
		this.attributeKind = attributeKind;
		this.attributeName = attributeName;
		this.updateDateTime = updateDateTime;
	}

	// Property accessors

	public Short getPbcId() {
		return this.pbcId;
	}

	public void setPbcId(Short pbcId) {
		this.pbcId = pbcId;
	}

	public String getAttributeKind() {
		return this.attributeKind;
	}

	public void setAttributeKind(String attributeKind) {
		this.attributeKind = attributeKind;
	}

	public String getAttributeName() {
		return this.attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public Date getUpdateDateTime() {
		return this.updateDateTime;
	}

	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

}