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
	//��������
	public abstract int addCstService(CstService service);
	//ɾ��
	public abstract int del(Long id);
	//�����еĸ߼���ѯ
	public abstract List<CstService> finByService();
	//�����в�ѯ����
	public abstract List<CstService> getAllService();
	//����
	public abstract List<CstService> getAllServiceChuLi();
	//����
	public abstract List<CstService> getAllServiceFanKui();
	//�鵵
	public abstract List<CstService> getAllServiceGuiDang();
	//�߼���ѯ
	public abstract List<CstService> selService(CstService service,String svrCreateDate1,String svrCreateDate2);

	public abstract void attachDirty(CstService instance);

	public abstract List<String[]> findServicByDict();

	public abstract void update2(String svrResult, int svrSatisfy, int svrId);

	public abstract List<CstService> listAll(CstService cs,String svrCreateDate1,String svrCreateDate2);

	
}