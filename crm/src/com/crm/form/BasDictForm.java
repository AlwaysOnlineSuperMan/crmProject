package com.crm.form;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.crm.entity.BasDict;
import com.crm.entity.SysRole;
import com.crm.util.PageModel;

/**
 * BasDict form. @author ÄþË¼
 */

public class BasDictForm extends ActionForm implements java.io.Serializable {

	// Fields

	private Long dictId;
	private String dictType;
	private String dictItem;
	private String dictValue;
	private Boolean dictIsEditable;
	private Timestamp dictUpdateDatetime;
	public List<BasDict> getBasDictObjectList() {
		return basDictObjectList;
	}

	public void setBasDictObjectList(List<BasDict> basDictObjectList) {
		this.basDictObjectList = basDictObjectList;
	}

	private List<BasDict> basDictObjectList = new ArrayList<BasDict>();
	private PageModel<BasDict> pageModel = new PageModel<BasDict>();

	

	

	public PageModel<BasDict> getPageModel() {
		return pageModel;
	}

	public void setPageModel(PageModel<BasDict> pageModel) {
		this.pageModel = pageModel;
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

}