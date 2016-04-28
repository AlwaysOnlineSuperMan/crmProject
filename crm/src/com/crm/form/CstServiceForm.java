package com.crm.form;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.crm.entity.BasDict;
import com.crm.entity.CstCustomer;
import com.crm.entity.CstService;
import com.crm.entity.SalChance;
import com.crm.entity.SysUser;

/**
 * CstService entity. @author MyEclipse Persistence Tools
 */

public class CstServiceForm extends ActionForm implements java.io.Serializable {

	// Fields
	private Long svrId;
	private CstCustomerForm cstCustomer = new CstCustomerForm();
	private String svrType;
	private String svrTitle;
	private String svrCustName;
	private String svrStatus;
	private String svrRequest;
	private Long svrCreateId;
	private String svrCreateBy;
	private Timestamp svrCreateDate;
	private Long svrDueId;
	private String svrDueTo;
	private Timestamp svrDueDate;
	private String svrDeal;
	private Long svrDealId;
	private String svrDealBy;
	private Timestamp svrDealDate;
	private String svrResult;
	private Integer svrSatisfy;
	private String svrUpdateDatetime;
	private Timestamp svrBeginDate;
	private Timestamp svrEndDate;
	
	private List<CstCustomer> cstCustomerList = new ArrayList<CstCustomer>();
	private List<BasDict> basDictList=new ArrayList<BasDict>();
	private List<SysUser> sysUserList=new ArrayList<SysUser>();

	private CstService cstservice=new CstService();

	public List<BasDict> getBasDictList() {
		return basDictList;
	}
	public void setBasDictList(List<BasDict> basDictList) {
		this.basDictList = basDictList;
	}
	
	private String svrCustNo;
	
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

	
	public String getSvrCustNo() {
		return svrCustNo;
	}
	public void setSvrCustNo(String svrCustNo) {
		this.svrCustNo = svrCustNo;
	}


	public List<CstCustomer> getCstCustomerList() {
		return cstCustomerList;
	}

	
	
	// Property accessors

	public Long getSvrId() {
		return this.svrId;
	}


	public void setSvrId(Long svrId) {
		this.svrId = svrId;
	}

	public CstCustomerForm getCstCustomer() {
		return this.cstCustomer;
	}

	public void setCstCustomer(CstCustomerForm cstCustomer) {
		this.cstCustomer = cstCustomer;
	}

	public void setCstCustomerList(List<CstCustomer> cstCustomerList) {
		this.cstCustomerList = cstCustomerList;
	}


	public String getSvrType() {
		return this.svrType;
	}

	public void setSvrType(String svrType) {
		this.svrType = svrType;
	}

	public String getSvrTitle() {
		return this.svrTitle;
	}

	public void setSvrTitle(String svrTitle) {
		this.svrTitle = svrTitle;
	}

	public String getSvrCustName() {
		return this.svrCustName;
	}

	public void setSvrCustName(String svrCustName) {
		this.svrCustName = svrCustName;
	}

	public String getSvrStatus() {
		return this.svrStatus;
	}

	public void setSvrStatus(String svrStatus) {
		this.svrStatus = svrStatus;
	}

	public String getSvrRequest() {
		return this.svrRequest;
	}

	public void setSvrRequest(String svrRequest) {
		this.svrRequest = svrRequest;
	}

	public Long getSvrCreateId() {
		return this.svrCreateId;
	}

	public void setSvrCreateId(Long svrCreateId) {
		this.svrCreateId = svrCreateId;
	}

	public String getSvrCreateBy() {
		return this.svrCreateBy;
	}

	public void setSvrCreateBy(String svrCreateBy) {
		this.svrCreateBy = svrCreateBy;
	}

	public Timestamp getSvrCreateDate() {
		return this.svrCreateDate;
	}

	public void setSvrCreateDate(Timestamp svrCreateDate) {
		this.svrCreateDate = svrCreateDate;
	}

	public Long getSvrDueId() {
		return this.svrDueId;
	}

	public void setSvrDueId(Long svrDueId) {
		this.svrDueId = svrDueId;
	}

	public String getSvrDueTo() {
		return this.svrDueTo;
	}

	public void setSvrDueTo(String svrDueTo) {
		this.svrDueTo = svrDueTo;
	}

	public Timestamp getSvrDueDate() {
		return this.svrDueDate;
	}

	public void setSvrDueDate(Timestamp svrDueDate) {
		this.svrDueDate = svrDueDate;
	}

	public String getSvrDeal() {
		return this.svrDeal;
	}

	public void setSvrDeal(String svrDeal) {
		this.svrDeal = svrDeal;
	}

	public Long getSvrDealId() {
		return this.svrDealId;
	}

	public void setSvrDealId(Long svrDealId) {
		this.svrDealId = svrDealId;
	}

	public String getSvrDealBy() {
		return this.svrDealBy;
	}

	public void setSvrDealBy(String svrDealBy) {
		this.svrDealBy = svrDealBy;
	}

	public Timestamp getSvrDealDate() {
		return this.svrDealDate;
	}

	public void setSvrDealDate(Timestamp svrDealDate) {
		this.svrDealDate = svrDealDate;
	}

	public String getSvrResult() {
		return this.svrResult;
	}

	public void setSvrResult(String svrResult) {
		this.svrResult = svrResult;
	}

	public Integer getSvrSatisfy() {
		return this.svrSatisfy;
	}

	public void setSvrSatisfy(Integer svrSatisfy) {
		this.svrSatisfy = svrSatisfy;
	}

	public String getSvrUpdateDatetime() {
		return this.svrUpdateDatetime;
	}

	public void setSvrUpdateDatetime(String svrUpdateDatetime) {
		this.svrUpdateDatetime = svrUpdateDatetime;
	}

	public void setCstservice(CstService cstservice) {
		this.cstservice = cstservice;
	}

	public CstService getCstservice() {
		return cstservice;
	}

	public void setSysUserList(List<SysUser> sysUserList) {
		this.sysUserList = sysUserList;
	}
	public List<SysUser> getSysUserList() {
		return sysUserList;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getCount() {
		return count;
	}
	public Timestamp getSvrBeginDate() {
		return svrBeginDate;
	}
	public void setSvrBeginDate(Timestamp svrBeginDate) {
		this.svrBeginDate = svrBeginDate;
	}
	public Timestamp getSvrEndDate() {
		return svrEndDate;
	}
	public void setSvrEndDate(Timestamp svrEndDate) {
		this.svrEndDate = svrEndDate;
	}
}