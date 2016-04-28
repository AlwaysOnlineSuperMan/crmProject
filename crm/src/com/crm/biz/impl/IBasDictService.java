package com.crm.biz.impl;

import java.util.List;

import com.crm.dao.BasDictDAO;
import com.crm.entity.BasDict;
import com.crm.entity.SysRole;
import com.crm.util.PageModel;

public interface IBasDictService {
	//查询所有客户等级
    public List<BasDict> selectAll();
 	//查询所有客户等记
 	public abstract List<BasDict> getByType(String address);
 	//服务类型
 	public abstract List<BasDict>  findTypeByServiceType() ;
 	public abstract List<String[]> Select2();
 	public abstract List<BasDict> getDasDictAll();

 	public abstract BasDict getBasDictByID(Long dictId);
 	public abstract void addOrUpdateBasDict(BasDict basDict);
 	 public abstract List custList();
 	public PageModel<BasDict> getPageModel(BasDict basDict,int page,int pageSize)throws Exception;
}