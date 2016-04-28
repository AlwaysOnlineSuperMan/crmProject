package com.crm.biz;

import java.util.List;

import com.crm.biz.impl.ICstLinkmanService;
import com.crm.dao.impl.ICstLinkmanDAO;
import com.crm.entity.CstLinkman;



public class CstLinkmanService implements java.io.Serializable, ICstLinkmanService {
   private	ICstLinkmanDAO cstLinkmanDAO;

   public void setCstLinkmanDAO(ICstLinkmanDAO cstLinkmanDAO) {
	   this.cstLinkmanDAO = cstLinkmanDAO;
   }
   public List<CstLinkman> getByNo(String custNo)throws Exception{
	   	List<CstLinkman> list = cstLinkmanDAO.findByNo(custNo);
	return list;
   }
   public CstLinkman getById(Long Id)throws Exception{
	   	CstLinkman cstlinkman = cstLinkmanDAO.findById(Id);
	return cstlinkman;
  }
   public void delById(Long lkmId) {
	    cstLinkmanDAO.delById(lkmId);
	
   }
   public void saveOrUpd(CstLinkman cstlinkman)throws Exception{
	   cstLinkmanDAO.saveOrUpdate(cstlinkman);
   }
	public void Update(CstLinkman cst) throws Exception{
		
		 cstLinkmanDAO.saveOrUpdate(cst);
	}

}