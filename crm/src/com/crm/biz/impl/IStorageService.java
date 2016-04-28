package com.crm.biz.impl;

import java.util.List;

import com.crm.entity.Storage;
import com.crm.util.PageModel;

public interface IStorageService {
	public abstract List<Storage> getStorageAll();
	public abstract PageModel<Storage>  getPageModel(String[] strs,Storage storage ,int currPage,int pageSize);
}