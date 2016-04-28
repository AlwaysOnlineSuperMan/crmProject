package com.crm.entity;

import java.sql.Timestamp;

/**
 * BasDict entity. @author MyEclipse Persistence Tools
 */

public class BasDict implements java.io.Serializable {

	// Fields


	private Long dictId;
	private String dictType;
	private String dictItem;
	private String dictValue;
	private Boolean dictIsEditable;
	private Timestamp dictUpdateDatetime;

	// Constructors

	/** default constructor */
	public BasDict() {
	}

	/** full constructor */
	public BasDict(String dictType, String dictItem, String dictValue,
			Boolean dictIsEditable, Timestamp dictUpdateDatetime) {
		this.dictType = dictType;
		this.dictItem = dictItem;
		this.dictValue = dictValue;
		this.dictIsEditable = dictIsEditable;
		this.dictUpdateDatetime = dictUpdateDatetime;
	}

	// Property accessors

	public Long getDictId() {
		return this.dictId;
	}

	public void setDictId(Long dictId) {
		this.dictId = dictId;
	}

	public String getDictType() {
		return this.dictType;
	}

	public void setDictType(String dictType) {
		this.dictType = dictType;
	}

	public String getDictItem() {
		return this.dictItem;
	}

	public void setDictItem(String dictItem) {
		this.dictItem = dictItem;
	}

	public String getDictValue() {
		return this.dictValue;
	}

	public void setDictValue(String dictValue) {
		this.dictValue = dictValue;
	}

	public Boolean getDictIsEditable() {
		return this.dictIsEditable;
	}

	public void setDictIsEditable(Boolean dictIsEditable) {
		this.dictIsEditable = dictIsEditable;
	}

	public Timestamp getDictUpdateDatetime() {
		return this.dictUpdateDatetime;
	}

	public void setDictUpdateDatetime(Timestamp dictUpdateDatetime) {
		this.dictUpdateDatetime = dictUpdateDatetime;
	}

	@Override
	public String toString() {
		return "BasDict [dictId=" + dictId + ", dictIsEditable="
				+ dictIsEditable + ", dictItem=" + dictItem + ", dictType="
				+ dictType + ", dictUpdateDatetime=" + dictUpdateDatetime
				+ ", dictValue=" + dictValue + "]";
	}

	
}