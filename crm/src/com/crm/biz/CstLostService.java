package com.crm.biz;

import java.util.List;

import com.crm.biz.impl.ICstLostService;
import com.crm.dao.impl.ICstLostDAO;
import com.crm.entity.CstLost;



public class CstLostService implements java.io.Serializable, ICstLostService {
	private ICstLostDAO cstLostDAO;

	public void setCstLostDAO(ICstLostDAO cstLostDAO) {
		this.cstLostDAO = cstLostDAO;
	}
	
	
	public List<CstLost> getCstLostAll() throws Exception{
		return cstLostDAO.findAll();
	}


	public CstLost getByCustName(String lstCustName) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}


	public CstLost getById(Long lsId) throws Exception{
		CstLost cstLost = cstLostDAO.findById(lsId);
		return cstLost;
	}


	public void saveOrUpdate(CstLost cstLost) throws Exception{
		cstLostDAO.saveOrUpdate(cstLost);
		
	}


	
}