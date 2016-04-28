package com.crm.form;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.crm.entity.Storage;
import com.crm.util.PageModel;

/**
 * Storage entity. @author MyEclipse Persistence Tools
 */

public class StorageForm extends ActionForm implements java.io.Serializable {

	// Fields


	private Long stkId;
	private Long stkProdId;
	private String stkProductName;
	private String stkWarehouse;
	private String stkWare;
	private Integer stkCount;
	private String stkMemo;
	private Timestamp stkUpdateDatetime;
	private List<Storage> storageList = new ArrayList<Storage>();
	private PageModel<Storage> pageModel = new PageModel<Storage>();
	
	
	public String getStkProductName() {
		return stkProductName;
	}

	public void setStkProductName(String stkProductName) {
		this.stkProductName = stkProductName;
	}

	public String getStkWarehouse() {
		return stkWarehouse;
	}

	public void setStkWarehouse(String stkWarehouse) {
		this.stkWarehouse = stkWarehouse;
	}

	
	
	public PageModel<Storage> getPageModel() {
		return pageModel;
	}

	public void setPageModel(PageModel<Storage> pageModel) {
		this.pageModel = pageModel;
	}

	public List<Storage> getStorageList() {
		return storageList;
	}

	public void setStorageList(List<Storage> storageList) {
		this.storageList = storageList;
	}

	// Property accessors

	public Long getStkId() {
		return this.stkId;
	}

	public void setStkId(Long stkId) {
		this.stkId = stkId;
	}

	public Long getStkProdId() {
		return this.stkProdId;
	}

	public void setStkProdId(Long stkProdId) {
		this.stkProdId = stkProdId;
	}



	public String getStkWare() {
		return this.stkWare;
	}

	public void setStkWare(String stkWare) {
		this.stkWare = stkWare;
	}

	public Integer getStkCount() {
		return this.stkCount;
	}

	public void setStkCount(Integer stkCount) {
		this.stkCount = stkCount;
	}

	public String getStkMemo() {
		return this.stkMemo;
	}

	public void setStkMemo(String stkMemo) {
		this.stkMemo = stkMemo;
	}

	public Timestamp getStkUpdateDatetime() {
		return this.stkUpdateDatetime;
	}

	public void setStkUpdateDatetime(Timestamp stkUpdateDatetime) {
		this.stkUpdateDatetime = stkUpdateDatetime;
	}

}