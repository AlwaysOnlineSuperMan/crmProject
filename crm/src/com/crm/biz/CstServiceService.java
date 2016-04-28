package com.crm.biz;


import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Query;

import com.crm.biz.impl.ICstServiceService;
import com.crm.dao.impl.IBasDictDAO;
import com.crm.dao.impl.ICstServiceDAO;
import com.crm.dao.impl.ISysUserDAO;
import com.crm.entity.BasDict;
import com.crm.entity.CstService;



public class CstServiceService implements java.io.Serializable, ICstServiceService {
	private ICstServiceDAO cstServiceDAO;//服务
	private IBasDictDAO dictdao;//字典
	private ISysUserDAO userdao;//用户
	public void update2(String svrResult,int svrSatisfy,int svrId){
		cstServiceDAO.update2(svrResult, svrSatisfy, svrId);
	}
	public CstService FindServiceById(Long id){
		CstService findById = cstServiceDAO.findById(id);
		return findById;
	}
	public List<CstService> listAll(CstService cs,String svrCreateDate1,String svrCreateDate2){
		return cstServiceDAO.listAll(cs,svrCreateDate1,svrCreateDate2);
	}
	//修改服务
	public void updateService(CstService cs){
		cstServiceDAO.attachDirty(cs);
	}
	
	public List<BasDict> InitialDict(Object object) {
		List<BasDict> findByDictType = dictdao.findByDictType(object);
		return findByDictType;
	}
	public IBasDictDAO getDictdao() {
		return dictdao;
	}
	public void setDictdao(IBasDictDAO dictdao) {
		this.dictdao = dictdao;
	}
	public ISysUserDAO getUserdao() {
		return userdao;
	}
	public void setUserdao(ISysUserDAO userdao) {
		this.userdao = userdao;
	}
	public List<CstService> selService(CstService service,String svrCreateDate1,String svrCreateDate2){
		List<CstService> list=cstServiceDAO.selService(service,svrCreateDate1,svrCreateDate2);
		return list;
	}
	//获取ID修改
	public CstService getCstServiceEdit(Long id){
		CstService cstService=cstServiceDAO.findById(id);
		return cstService;
	}
	//创建服务
	public void addCstService(CstService service) {
		this.cstServiceDAO.save(service);
	}
	//删除
	public int del(Long id) {
		return cstServiceDAO.del(id);
	}
	public List<CstService> findAll() {
		List<CstService> list=cstServiceDAO.findAll();
		return list;
	}
	//分配中的高级查询
	public List<CstService> finByService(){
		List<CstService> list=cstServiceDAO.finByService();
		return list;
	}
	//分配
	public List<CstService> getAllService(){
		List<CstService> list=cstServiceDAO.getAllService();
		return list;
	}
	//归档
	public List<CstService> getAllServiceGuiDang(){
		List<CstService> list=cstServiceDAO.getAllServiceGuiDang();
		return list;
	}
	//反馈
	public List<CstService> getAllServiceFanKui(){
		List<CstService> list=cstServiceDAO.getAllServiceFanKui();
		return list;
	}
	//处理
	public List<CstService> getAllServiceChuLi(){
		List<CstService> list=cstServiceDAO.getAllServiceChuLi();
		return list;
	}

	public ICstServiceDAO getCstServiceDAO() {
		return cstServiceDAO;
	}
	public void setCstServiceDAO(ICstServiceDAO cstServiceDAO) {
		this.cstServiceDAO = cstServiceDAO;
	}
	public List<String[]> findServicByDict() {
		// TODO Auto-generated method stub
		return cstServiceDAO.findServicByDict();
	}
}