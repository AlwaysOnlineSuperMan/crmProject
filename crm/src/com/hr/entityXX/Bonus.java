package com.hr.entityXX;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Bonus entity. @author MyEclipse Persistence Tools
 */

public class Bonus implements java.io.Serializable {

	// Fields

	private Short bonId;
	private String majorKindId;
	private String majorKindName;
	private String majorId;
	private String majorName;
	private String humanId;
	private String humanName;
	private String bonusItem;
	private Float bonusWorth;
	private String bonusDegree;
	private String remark;
	private String register;
	private String checker;
	private Timestamp registTime;
	private Timestamp checkTime;
	private Short checkStatus;
	private Date updateDateTime;

	// Constructors

	/** default constructor */
	public Bonus() {
	}

	/** full constructor */
	public Bonus(String majorKindId, String majorKindName, String majorId,
			String majorName, String humanId, String humanName,
			String bonusItem, Float bonusWorth, String bonusDegree,
			String remark, String register, String checker,
			Timestamp registTime, Timestamp checkTime, Short checkStatus,
			Date updateDateTime) {
		this.majorKindId = majorKindId;
		this.majorKindName = majorKindName;
		this.majorId = majorId;
		this.majorName = majorName;
		this.humanId = humanId;
		this.humanName = humanName;
		this.bonusItem = bonusItem;
		this.bonusWorth = bonusWorth;
		this.bonusDegree = bonusDegree;
		this.remark = remark;
		this.register = register;
		this.checker = checker;
		this.registTime = registTime;
		this.checkTime = checkTime;
		this.checkStatus = checkStatus;
		this.updateDateTime = updateDateTime;
	}

	// Property accessors

	public Short getBonId() {
		return this.bonId;
	}

	public void setBonId(Short bonId) {
		this.bonId = bonId;
	}

	public String getMajorKindId() {
		return this.majorKindId;
	}

	public void setMajorKindId(String majorKindId) {
		this.majorKindId = majorKindId;
	}

	public String getMajorKindName() {
		return this.majorKindName;
	}

	public void setMajorKindName(String majorKindName) {
		this.majorKindName = majorKindName;
	}

	public String getMajorId() {
		return this.majorId;
	}

	public void setMajorId(String majorId) {
		this.majorId = majorId;
	}

	public String getMajorName() {
		return this.majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
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

	public String getBonusItem() {
		return this.bonusItem;
	}

	public void setBonusItem(String bonusItem) {
		this.bonusItem = bonusItem;
	}

	public Float getBonusWorth() {
		return this.bonusWorth;
	}

	public void setBonusWorth(Float bonusWorth) {
		this.bonusWorth = bonusWorth;
	}

	public String getBonusDegree() {
		return this.bonusDegree;
	}

	public void setBonusDegree(String bonusDegree) {
		this.bonusDegree = bonusDegree;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRegister() {
		return this.register;
	}

	public void setRegister(String register) {
		this.register = register;
	}

	public String getChecker() {
		return this.checker;
	}

	public void setChecker(String checker) {
		this.checker = checker;
	}

	public Timestamp getRegistTime() {
		return this.registTime;
	}

	public void setRegistTime(Timestamp registTime) {
		this.registTime = registTime;
	}

	public Timestamp getCheckTime() {
		return this.checkTime;
	}

	public void setCheckTime(Timestamp checkTime) {
		this.checkTime = checkTime;
	}

	public Short getCheckStatus() {
		return this.checkStatus;
	}

	public void setCheckStatus(Short checkStatus) {
		this.checkStatus = checkStatus;
	}

	public Date getUpdateDateTime() {
		return this.updateDateTime;
	}

	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

}