package com.crm.biz.impl;

import java.sql.Timestamp;
import java.util.List;

import com.crm.entity.BasDict;
import com.crm.entity.CstService;

public interface ICstServiceService {
	//创建服务
	public abstract void addCstService(CstService service);
	//删除
	public abstract int del(Long id);
	public abstract List<CstService> findAll();
	public abstract List<CstService> finByService();
	//分配中查询所有
	public abstract List<CstService> getAllService();
	public abstract List<CstService> getAllServiceChuLi();
	public abstract List<CstService> getAllServiceGuiDang();
	public abstract List<CstService> getAllServiceFanKui();
	//处理
	public abstract CstService getCstServiceEdit(Long id);
	
	public abstract List<CstService> selService(CstService service,String svrCreateDate1,String svrCreateDate2);

	public abstract CstService FindServiceById(Long id);
	public abstract void updateService(CstService cs);

	public abstract List<CstService> listAll(CstService cs,String svrCreateDate1,String svrCreateDate2);

	public abstract List<String[]> findServicByDict();
	public abstract void update2(String svrResult, int svrSatisfy, int svrId);

}