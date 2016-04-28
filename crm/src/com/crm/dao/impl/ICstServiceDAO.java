package com.crm.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Query;

import com.crm.entity.CstService;

public interface ICstServiceDAO {
	
	public abstract void save(CstService transientInstance);

	public abstract void delete(CstService persistentInstance);

	public abstract CstService findById(java.lang.Long id);
	public abstract List findAll();
	//创建服务
	public abstract int addCstService(CstService service);
	//删除
	public abstract int del(Long id);
	//分配中的高级查询
	public abstract List<CstService> finByService();
	//分配中查询所有
	public abstract List<CstService> getAllService();
	//处理
	public abstract List<CstService> getAllServiceChuLi();
	//反馈
	public abstract List<CstService> getAllServiceFanKui();
	//归档
	public abstract List<CstService> getAllServiceGuiDang();
	//高级查询
	public abstract List<CstService> selService(CstService service,String svrCreateDate1,String svrCreateDate2);

	public abstract void attachDirty(CstService instance);

	public abstract List<String[]> findServicByDict();

	public abstract void update2(String svrResult, int svrSatisfy, int svrId);

	public abstract List<CstService> listAll(CstService cs,String svrCreateDate1,String svrCreateDate2);

	
}