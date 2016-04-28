package com.crm.biz;

import java.util.List;

import com.crm.biz.impl.ISalChanceService;
import com.crm.dao.impl.ISalChanceDAO;
import com.crm.entity.SalChance;
import com.crm.entity.SalPlan;
import com.crm.util.AppException;



public class SalChanceService implements java.io.Serializable, ISalChanceService {

	private ISalChanceDAO salChanceDAO;

	public void setSalChanceDAO(ISalChanceDAO salChanceDAO) {
		this.salChanceDAO = salChanceDAO;
	}

	public List<SalChance> findAllSalChance(){
		
		return salChanceDAO.findAll();
	}

	/**
	 * 
	 * @param custName 		客服名字
	 * @param chcTitle 		概要
	 * @param chcLinkman  	联系人
	 * @param pageSize 		每页pageSize条
	 * @param transmitPage 	转到第transmitPage页页
	 * @param userRoleID 	登陆者的权利ID
	 * @return 按条件查询出的 销售机会所有符合数据
	 */
	public List<SalChance> getFindPropertySalChanceList(String custName,String chcTitle,String chcLinkman,int pageSize,int transmitPage,Long userRoleID,Long usrID,String chcStatus)throws Exception{
		List<SalChance> salChanceObjectList = salChanceDAO.findPropertyList(custName, chcTitle, chcLinkman, pageSize, transmitPage, userRoleID,usrID,chcStatus);
			return salChanceObjectList;
	}
	
	
	public Long getFindPropertySalChanceCount(String custName,String chcTitle,String chcLinkman,int pageSize,int transmitPage,Long userRoleID,Long usrID,String chcStatus)throws Exception{
		Long salPlanCount = salChanceDAO.findPropertyCount(custName, chcTitle, chcLinkman, pageSize, transmitPage, userRoleID,usrID,chcStatus);
		return salPlanCount;
	}

	public  void addSalChanceSeva(SalChance salChanceObject)throws Exception{
		salChanceDAO.save(salChanceObject);
	}
	
	public SalChance getSalChanceByID(Long chcId)throws Exception{
		SalChance salChanceObject = salChanceDAO.findById(chcId);
		return salChanceObject;
		
		
	}

	public void delSalChance(Long chcId)throws Exception {
		if (!salChanceDAO.delete(chcId)) {
			throw new AppException("error.delete",new Object[]{chcId});
		}
	}
	public void addSaveOrUpdate(SalChance salChance)throws Exception{
		
		boolean bool=salChanceDAO.saveOrUpdate(salChance);
		if (!bool) {
			throw new AppException("error.update",new Object[]{salChance.getChcUpdateDatetime()});
		}

	}
	
	public void updDispatch(SalChance salChanceObject)throws Exception{
		if(!salChanceDAO.updDispatch(salChanceObject)){
			throw new AppException("error.dispatch",new Object[]{salChanceObject.getChcUpdateDatetime()});
		};
		
	}

	public void updloseSalChance(SalChance salChanceObject)throws Exception{
		salChanceDAO.loseSalChance(salChanceObject);
	}
	public void  successSalChance(SalChance salChanceObject) throws Exception{
		salChanceDAO.successSalChance(salChanceObject);
	}
}