package com.crm.form;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.struts.action.ActionForm;

import com.crm.entity.BasDict;
import com.crm.entity.SysUser;

/**
 * CstCustomer from. @author ÄþË¼
 */

public class CstCustomerForm extends ActionForm implements java.io.Serializable {

	// Fields

	private String custNo;
	private String custName;
	private String custRegion;
	private Long custManagerId;
	private String custManagerName;
	private Integer custLevel;
	private String custLevelLabel;
	private Integer custSatisfy;
	private Integer custCredit;
	private String custAddr;
	private String custZip;
	private String custTel;
	private String custFax;
	private String custWebsite;
	private String custLicenceNo;
	private String custChieftain;
	private Long custBankroll;
	private Long custTurnover;
	private String custBank;
	private String custBankAccount;
	private String custLocalTaxNo;
	private String custNationalTaxNo;
	private String custStatus;
	private Timestamp custUpdateDatetime;
	private Set cstServices = new HashSet(0);
	private Set cstLinkmans = new HashSet(0);
	private Set cstActivities = new HashSet(0);
	private Set cstLosts = new HashSet(0);
	List<BasDict> basdictList = new ArrayList<BasDict>();
	List<BasDict> dictList = new ArrayList<BasDict>();
	List<SysUser> sysuserList = new ArrayList<SysUser>();

	

	// Property accessors
	

	public String getCustNo() {
		return this.custNo;
	}

	public List<SysUser> getSysuserList() {
		return sysuserList;
	}

	public void setSysuserList(List<SysUser> sysuserList) {
		this.sysuserList = sysuserList;
	}

	public List<BasDict> getDictList() {
		return dictList;
	}

	public void setDictList(List<BasDict> dictList) {
		this.dictList = dictList;
	}

	public List<BasDict> getBasdictList() {
		return basdictList;
	}

	public void setBasdictList(List<BasDict> basdictList) {
		this.basdictList = basdictList;
	}

	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}

	public String getCustName() {
		return this.custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustRegion() {
		return this.custRegion;
	}

	public void setCustRegion(String custRegion) {
		this.custRegion = custRegion;
	}

	public Long getCustManagerId() {
		return this.custManagerId;
	}

	public void setCustManagerId(Long custManagerId) {
		this.custManagerId = custManagerId;
	}

	public String getCustManagerName() {
		return this.custManagerName;
	}

	public void setCustManagerName(String custManagerName) {
		this.custManagerName = custManagerName;
	}

	public Integer getCustLevel() {
		return this.custLevel;
	}

	public void setCustLevel(Integer custLevel) {
		this.custLevel = custLevel;
	}

	public String getCustLevelLabel() {
		return this.custLevelLabel;
	}

	public void setCustLevelLabel(String custLevelLabel) {
		this.custLevelLabel = custLevelLabel;
	}

	public Integer getCustSatisfy() {
		return this.custSatisfy;
	}

	public void setCustSatisfy(Integer custSatisfy) {
		this.custSatisfy = custSatisfy;
	}

	public Integer getCustCredit() {
		return this.custCredit;
	}

	public void setCustCredit(Integer custCredit) {
		this.custCredit = custCredit;
	}

	public String getCustAddr() {
		return this.custAddr;
	}

	public void setCustAddr(String custAddr) {
		this.custAddr = custAddr;
	}

	public String getCustZip() {
		return this.custZip;
	}

	public void setCustZip(String custZip) {
		this.custZip = custZip;
	}

	public String getCustTel() {
		return this.custTel;
	}

	public void setCustTel(String custTel) {
		this.custTel = custTel;
	}

	public String getCustFax() {
		return this.custFax;
	}

	public void setCustFax(String custFax) {
		this.custFax = custFax;
	}

	public String getCustWebsite() {
		return this.custWebsite;
	}

	public void setCustWebsite(String custWebsite) {
		this.custWebsite = custWebsite;
	}

	public String getCustLicenceNo() {
		return this.custLicenceNo;
	}

	public void setCustLicenceNo(String custLicenceNo) {
		this.custLicenceNo = custLicenceNo;
	}

	public String getCustChieftain() {
		return this.custChieftain;
	}

	public void setCustChieftain(String custChieftain) {
		this.custChieftain = custChieftain;
	}

	public Long getCustBankroll() {
		return this.custBankroll;
	}

	public void setCustBankroll(Long custBankroll) {
		this.custBankroll = custBankroll;
	}

	public Long getCustTurnover() {
		return this.custTurnover;
	}

	public void setCustTurnover(Long custTurnover) {
		this.custTurnover = custTurnover;
	}

	public String getCustBank() {
		return this.custBank;
	}

	public void setCustBank(String custBank) {
		this.custBank = custBank;
	}

	public String getCustBankAccount() {
		return this.custBankAccount;
	}

	public void setCustBankAccount(String custBankAccount) {
		this.custBankAccount = custBankAccount;
	}

	public String getCustLocalTaxNo() {
		return this.custLocalTaxNo;
	}

	public void setCustLocalTaxNo(String custLocalTaxNo) {
		this.custLocalTaxNo = custLocalTaxNo;
	}

	public String getCustNationalTaxNo() {
		return this.custNationalTaxNo;
	}

	public void setCustNationalTaxNo(String custNationalTaxNo) {
		this.custNationalTaxNo = custNationalTaxNo;
	}

	public String getCustStatus() {
		return this.custStatus;
	}

	public void setCustStatus(String custStatus) {
		this.custStatus = custStatus;
	}

	public Timestamp getCustUpdateDatetime() {
		return this.custUpdateDatetime;
	}

	public void setCustUpdateDatetime(Timestamp custUpdateDatetime) {
		this.custUpdateDatetime = custUpdateDatetime;
	}

	public Set getCstServices() {
		return this.cstServices;
	}

	public void setCstServices(Set cstServices) {
		this.cstServices = cstServices;
	}

	public Set getCstLinkmans() {
		return this.cstLinkmans;
	}

	public void setCstLinkmans(Set cstLinkmans) {
		this.cstLinkmans = cstLinkmans;
	}

	public Set getCstActivities() {
		return this.cstActivities;
	}

	public void setCstActivities(Set cstActivities) {
		this.cstActivities = cstActivities;
	}

	public Set getCstLosts() {
		return this.cstLosts;
	}

	public void setCstLosts(Set cstLosts) {
		this.cstLosts = cstLosts;
	}

}