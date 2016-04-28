package com.crm.biz.impl;

import java.util.List;

import com.crm.entity.SalChance;
import com.crm.entity.SalPlan;

public interface ISalChanceService {
	public abstract List<SalChance> findAllSalChance();
	
	public abstract List<SalChance> getFindPropertySalChanceList(String custName,String chcTitle,String chcLinkman,int pageSize,int transmitPage,Long userRoleID,Long usrID,String chcStatus)throws Exception;	
	public abstract Long getFindPropertySalChanceCount(String custName,String chcTitle,String chcLinkman,int pageSize,int transmitPage,Long userRoleID,Long usrID,String chcStatus)throws Exception;	
	public abstract void addSalChanceSeva(SalChance salChanceObject)throws Exception;
	public abstract SalChance getSalChanceByID(Long chcId)throws Exception;
	public abstract void delSalChance(Long chcId)throws Exception;
	public abstract void addSaveOrUpdate(SalChance transientInstance)throws Exception;
	public abstract void updDispatch(SalChance salChanceObject)throws Exception;
	public abstract void updloseSalChance(SalChance salChanceObject)throws Exception;
	public abstract void successSalChance(SalChance salChanceObject) throws Exception;
}