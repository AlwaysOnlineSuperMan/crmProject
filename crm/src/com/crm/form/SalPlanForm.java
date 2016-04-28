package com.crm.form;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.crm.entity.SalPlan;
/**
 * SalPlan entity. @author MyEclipse Persistence Tools
 */

public class SalPlanForm extends ActionForm implements java.io.Serializable {

	// Fields

	private Long plaId;
	private SalChanceForm salChance = new SalChanceForm();
	private Timestamp plaDate;
	private String plaTodo;
	private String plaResult;
	private Timestamp plaUpdateDatetime;
	private String chcSource;
	private String chcCustName;
	private String chcTitle;
	private String chcLinkman;
	private Long chcId;

	public Long getChcId() {
		return chcId;
	}

	public void setChcId(Long chcId) {
		this.chcId = chcId;
	}

	public String getChcLinkman() {
		return chcLinkman;
	}

	public void setChcLinkman(String chcLinkman) {
		this.chcLinkman = chcLinkman;
	}

	public String getChcSource() {
		return chcSource;
	}

	public void setChcSource(String chcSource) {
		this.chcSource = chcSource;
	}

	public String getChcCustName() {
		return chcCustName;
	}

	public void setChcCustName(String chcCustName) {
		this.chcCustName = chcCustName;
	}

	public String getChcTitle() {
		return chcTitle;
	}

	public void setChcTitle(String chcTitle) {
		this.chcTitle = chcTitle;
	}

	private List<SalPlan> salPlanList = new ArrayList<SalPlan>();
	//add Fields Action com.crm.action.SalChanceAction method in 
	//每页pageSize条
	private int pageSize;
	//共count条记录
	private int count;
	//第页
	private int page;
	// Property accessors
	//共5页
	private int sumPage;
	//转到页
	private int transmitPage;
	
	
	
	
	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSumPage() {
		return sumPage;
	}

	public void setSumPage(int sumPage) {
		this.sumPage = sumPage;
	}

	public int getTransmitPage() {
		return transmitPage;
	}

	public void setTransmitPage(int transmitPage) {
		this.transmitPage = transmitPage;
	}

	public List<SalPlan> getSalPlanList() {
		return salPlanList;
	}

	public void setSalPlanList(List<SalPlan> salPlanList) {
		this.salPlanList = salPlanList;
	}

	
	// Property accessors

	public Long getPlaId() {
		return this.plaId;
	}

	public void setPlaId(Long plaId) {
		this.plaId = plaId;
	}

	public SalChanceForm getSalChance() {
		return this.salChance;
	}

	public void setSalChance(SalChanceForm salChance) {
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

}