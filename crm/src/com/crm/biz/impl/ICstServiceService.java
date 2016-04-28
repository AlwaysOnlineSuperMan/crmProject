package com.crm.biz.impl;

import java.sql.Timestamp;
import java.util.List;

import com.crm.entity.BasDict;
import com.crm.entity.CstService;

public interface ICstServiceService {
	//��������
	public abstract void addCstService(CstService service);
	//ɾ��
	public abstract int del(Long id);
	public abstract List<CstService> findAll();
	public abstract List<CstService> finByService();
	//�����в�ѯ����
	public abstract List<CstService> getAllService();
	public abstract List<CstService> getAllServiceChuLi();
	public abstract List<CstService> getAllServiceGuiDang();
	public abstract List<CstService> getAllServiceFanKui();
	//����
	public abstract CstService getCstServiceEdit(Long id);
	
	public abstract List<CstService> selService(CstService service,String svrCreateDate1,String svrCreateDate2);

	public abstract CstService FindServiceById(Long id);
	public abstract void updateService(CstService cs);

	public abstract List<CstService> listAll(CstService cs,String svrCreateDate1,String svrCreateDate2);

	public abstract List<String[]> findServicByDict();
	public abstract void update2(String svrResult, int svrSatisfy, int svrId);

}