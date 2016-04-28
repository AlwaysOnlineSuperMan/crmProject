package com.crm.form;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.crm.entity.Product;
import com.crm.util.PageModel;

/**
 * Product entity. @author MyEclipse Persistence Tools
 */

public class ProductForm extends ActionForm implements java.io.Serializable {

	// Fields

	private Long prodId;
	private String prodName;
	private String prodType;
	private String prodBatch;
	private String prodUnit;
	private Double prodPrice;
	private String prodMemo;
	private Timestamp prodUpdateDatetime;

	private List<Product> productList = new ArrayList<Product>();
	private PageModel<Product> pageModel = new PageModel<Product>();
	// Property accessors

	public PageModel<Product> getPageModel() {
		return pageModel;
	}

	public void setPageModel(PageModel<Product> pageModel) {
		this.pageModel = pageModel;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public Long getProdId() {
		return this.prodId;
	}

	public void setProdId(Long prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return this.prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdType() {
		return this.prodType;
	}

	public void setProdType(String prodType) {
		this.prodType = prodType;
	}

	public String getProdBatch() {
		return this.prodBatch;
	}

	public void setProdBatch(String prodBatch) {
		this.prodBatch = prodBatch;
	}

	public String getProdUnit() {
		return this.prodUnit;
	}

	public void setProdUnit(String prodUnit) {
		this.prodUnit = prodUnit;
	}

	public Double getProdPrice() {
		return this.prodPrice;
	}

	public void setProdPrice(Double prodPrice) {
		this.prodPrice = prodPrice;
	}

	public String getProdMemo() {
		return this.prodMemo;
	}

	public void setProdMemo(String prodMemo) {
		this.prodMemo = prodMemo;
	}

	public Timestamp getProdUpdateDatetime() {
		return this.prodUpdateDatetime;
	}

	public void setProdUpdateDatetime(Timestamp prodUpdateDatetime) {
		this.prodUpdateDatetime = prodUpdateDatetime;
	}

}