package com.crm.biz;

import java.util.List;

import com.crm.biz.impl.ICstActivityService;
import com.crm.biz.impl.ICstCustomerService;
import com.crm.dao.impl.ICstActivityDAO;
import com.crm.entity.CstActivity;
import com.crm.entity.CstCustomer;


public class CstActivityService implements  java.io.Serializable,ICstActivityService {
	private ICstActivityDAO cstActivityDAO;

	public void setCstActivityDAO(ICstActivityDAO cstActivityDAO) {
		this.cstActivityDAO = cstActivityDAO;
	}
	
	public ICstActivityDAO getCstActivityDAO() {
		return cstActivityDAO;
	}

	public List<CstActivity> getByNo(String custNo) throws Exception{
		List<CstActivity> list = cstActivityDAO.findByNo(custNo);
		return list;
		
	}

	public void Update(CstActivity cst) throws Exception{
		cstActivityDAO.saveOrUpdate(cst);
		
	}

	public void delById(Long lkmId) throws Exception{
		cstActivityDAO.delById(lkmId);
	}

	public CstActivity getById(Long Id) throws Exception{
		CstActivity activity = cstActivityDAO.findById(Id);
		return activity;
	}

	public void saveOrUpd(CstActivity cst) throws Exception{
		cstActivityDAO.saveOrUpdate(cst);
		
	}
}