package com.crm.form;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.struts.action.ActionForm;

import com.crm.entity.SysUser;

/**
 * SalChance entity. @author MyEclipse Persistence Tools
 */

public class SalChanceForm extends ActionForm implements java.io.Serializable {

	// Fields form Entity com.crm.SalChance Fields

	private Long chcId;
	private String chcSource;
	private String chcCustName;
	private String chcTitle;
	private Integer chcRate;
	private String chcLinkman;
	private String chcTel;
	private String chcDesc;
	private Long chcCreateId;
	private String chcCreateBy;
	private Timestamp chcCreateDate;//  = new Timestamp(System.currentTimeMillis());;
	private Long chcDueId;
	private String chcDueTo;
	private Timestamp chcDueDate;//  = new Timestamp(System.currentTimeMillis()); ;
	private String chcStatus;
	private Timestamp chcUpdateDatetime ;//= new Timestamp(System.currentTimeMillis());
	private Set salPlans = new HashSet(0);

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
	//指派
	List<SysUser> sysUserList = new ArrayList<SysUser>();
	
	
	
	
	
	
	public List<SysUser> getSysUserList() {
		return sysUserList;
	}

	public void setSysUserList(List<SysUser> sysUserList) {
		this.sysUserList = sysUserList;
	}

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

	public Long getChcId() {
		return this.chcId;
	}

	public void setChcId(Long chcId) {
		this.chcId = chcId;
	}

	public String getChcSource() {
		return this.chcSource;
	}

	public void setChcSource(String chcSource) {
		this.chcSource = chcSource;
	}

	public String getChcCustName() {
		return this.chcCustName;
	}

	public void setChcCustName(String chcCustName) {
		this.chcCustName = chcCustName;
	}

	public String getChcTitle() {
		return this.chcTitle;
	}

	public void setChcTitle(String chcTitle) {
		this.chcTitle = chcTitle;
	}

	public Integer getChcRate() {
		return this.chcRate;
	}

	public void setChcRate(Integer chcRate) {
		this.chcRate = chcRate;
	}

	public String getChcLinkman() {
		return this.chcLinkman;
	}

	public void setChcLinkman(String chcLinkman) {
		this.chcLinkman = chcLinkman;
	}

	public String getChcTel() {
		return this.chcTel;
	}

	public void setChcTel(String chcTel) {
		this.chcTel = chcTel;
	}

	public String getChcDesc() {
		return this.chcDesc;
	}

	public void setChcDesc(String chcDesc) {
		this.chcDesc = chcDesc;
	}

	public Long getChcCreateId() {
		return this.chcCreateId;
	}

	public void setChcCreateId(Long chcCreateId) {
		this.chcCreateId = chcCreateId;
	}

	public String getChcCreateBy() {
		return this.chcCreateBy;
	}

	public void setChcCreateBy(String chcCreateBy) {
		this.chcCreateBy = chcCreateBy;
	}

	public Timestamp getChcCreateDate() {
		return this.chcCreateDate;
	}

	public void setChcCreateDate(Timestamp chcCreateDate) {
		this.chcCreateDate = chcCreateDate;
	}

	public Long getChcDueId() {
		return this.chcDueId;
	}

	public void setChcDueId(Long chcDueId) {
		this.chcDueId = chcDueId;
	}

	public String getChcDueTo() {
		return this.chcDueTo;
	}

	public void setChcDueTo(String chcDueTo) {
		this.chcDueTo = chcDueTo;
	}

	public Timestamp getChcDueDate() {
		return this.chcDueDate;
	}

	public void setChcDueDate(Timestamp chcDueDate) {
		this.chcDueDate = chcDueDate;
	}

	public String getChcStatus() {
		return this.chcStatus;
	}

	public void setChcStatus(String chcStatus) {
		this.chcStatus = chcStatus;
	}

	public Timestamp getChcUpdateDatetime() {
		return this.chcUpdateDatetime;
	}

	public void setChcUpdateDatetime(Timestamp chcUpdateDatetime) {
		this.chcUpdateDatetime = chcUpdateDatetime;
	}

	public Set getSalPlans() {
		return this.salPlans;
	}

	public void setSalPlans(Set salPlans) {
		this.salPlans = salPlans;
	}

}