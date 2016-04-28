package com.crm.biz;

import java.util.List;

import com.crm.biz.impl.IBasDictService;
import com.crm.dao.BasDictDAO;
import com.crm.dao.impl.IBasDictDAO;
import com.crm.entity.BasDict;
import com.crm.util.PageModel;
import com.sun.swing.internal.plaf.basic.resources.basic;

public class BasDictService implements IBasDictService {
	private IBasDictDAO basDictDAO;
	public List<BasDict> selectAll() {
	     return basDictDAO.selectAll();
	}

	public IBasDictDAO getBasDictDAO() {
		return basDictDAO;
	}

	public void setBasDictDAO(IBasDictDAO basDictDAO) {
		this.basDictDAO = basDictDAO;
	}

	public List<BasDict> selectAlldq() {
		 
		return basDictDAO.selectAlldq();
	}
	public List<BasDict> selectAllmyd() {
		return basDictDAO.selectAllmyd();
	}
	public List<BasDict> selectAllxyd() {
		 
		return basDictDAO.selectAllxyd();
	}
	public BasDict seldjmc(int id) {
	 
		return basDictDAO.seldjmc(id);
	}
	public List<BasDict> getByType(String address){
		List<BasDict> list = basDictDAO.findByDictType(address);
		return list;
	}

	public  List<BasDict>  findTypeByServiceType() {
		return basDictDAO.findTypeByServiceType();
	}
	
	public List<BasDict> getDasDictAll() {
	     return basDictDAO.findAll();
	}


	public BasDict getBasDictByID(Long dictId) {
		
		return basDictDAO.findById(dictId);
	}
	public void addOrUpdateBasDict(BasDict basDict){
		basDictDAO.save(basDict);
	}

	public List<String[]> Select2() {
		return basDictDAO.Select2();
	}
	 public List custList(){
		 return basDictDAO.custList();
	 }

	public PageModel<BasDict> getPageModel(BasDict basDict, int page,
			int pageSize) throws Exception {
		return 	basDictDAO.getPageModel(basDict, page, pageSize);
	
	}

}
