package com.crm.entity;

import java.sql.Timestamp;

/**
 * SalPlan entity. @author MyEclipse Persistence Tools
 */

public class SalPlan implements java.io.Serializable {

	// Fields

	private Long plaId;
	private SalChance salChance = new SalChance();
	private Timestamp plaDate;
	private String plaTodo;
	private String plaResult;
	private Timestamp plaUpdateDatetime;
	private Long chcId;
	// Constructors

	public Long getChcId() {
		return chcId;
	}

	public void setChcId(Long chcId) {
		this.chcId = chcId;
	}

	/** default constructor */
	public SalPlan() {
	}

	/** minimal constructor */
	public SalPlan(SalChance salChance, Timestamp plaDate, String plaTodo) {
		this.salChance = salChance;
		this.plaDate = plaDate;
		this.plaTodo = plaTodo;
	}

	/** full constructor */
	public SalPlan(SalChance salChance, Timestamp plaDate, String plaTodo,
			String plaResult, Timestamp plaUpdateDatetime) {
		this.salChance = salChance;
		this.plaDate = plaDate;
		this.plaTodo = plaTodo;
		this.plaResult = plaResult;
		this.plaUpdateDatetime = plaUpdateDatetime;
	}

	// Property accessors

	public Long getPlaId() {
		return this.plaId;
	}

	public void setPlaId(Long plaId) {
		this.plaId = plaId;
	}

	public SalChance getSalChance() {
		return this.salChance;
	}

	public void setSalChance(SalChance salChance) {
		this.salChance = salChance;
	}

	public Timestamp getPlaDate() {
		return this.plaDate;
	}

	public void setPlaDate(Timestamp plaDate) {
		this.plaDate = plaDate;
	}

	public String getPlaTodo() {
		return this.plaTodo;
	}

	public void setPlaTodo(String plaTodo) {
		this.plaTodo = plaTodo;
	}

	public String getPlaResult() {
		return this.plaResult;
	}

	public void setPlaResult(String plaResult) {
		this.plaResult = plaResult;
	}

	public Timestamp getPlaUpdateDatetime() {
		return this.plaUpdateDatetime;
	}

	public void setPlaUpdateDatetime(Timestamp plaUpdateDatetime) {
		this.plaUpdateDatetime = plaUpdateDatetime;
	}

	@Override
	public String toString() {
		return "SalPlan [chcId=" + chcId + ", plaDate=" + plaDate + ", plaId="
				+ plaId + ", plaResult=" + plaResult + ", plaTodo=" + plaTodo
				+ ", plaUpdateDatetime=" + plaUpdateDatetime + ", salChance="
				+ salChance + "]";
	}

}