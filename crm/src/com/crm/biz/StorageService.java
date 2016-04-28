package com.crm.biz;

import java.util.List;

import com.crm.biz.impl.IStorageService;
import com.crm.dao.StorageDAO;
import com.crm.dao.impl.IStorageDAO;
import com.crm.entity.Storage;
import com.crm.util.PageModel;


public class StorageService implements java.io.Serializable, IStorageService {
	private IStorageDAO storageDAO;

	public void setStorageDAO(IStorageDAO storageDAO) {
		this.storageDAO = storageDAO;
	}

	public List<Storage> getStorageAll() {
		// TODO Auto-generated method stub
		return storageDAO.findAll();
	}

	public PageModel<Storage> getPageModel(String[] strs,Storage storage ,int currPage,int pageSize) {
		// TODO Auto-generated method stub
		return storageDAO.getPageModel(strs,storage, currPage, pageSize);
	}
	

}