package com.crm.dao.impl;

import java.util.List;

import com.crm.entity.SalChance;
import com.crm.entity.SalPlan;

public interface ISalChanceDAO {

	public abstract void save(SalChance transientInstance);

	public abstract void delete(SalChance persistentInstance);

	public abstract SalChance findById(java.lang.Long id);

	public abstract List findByExample(SalChance instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByChcSource(Object chcSource);

	public abstract List findByChcCustName(Object chcCustName);

	public abstract List findByChcTitle(Object chcTitle);

	public abstract List findByChcRate(Object chcRate);

	public abstract List findByChcLinkman(Object chcLinkman);

	public abstract List findByChcTel(Object chcTel);

	public abstract List findByChcDesc(Object chcDesc);

	public abstract List findByChcCreateId(Object chcCreateId);

	public abstract List findByChcCreateBy(Object chcCreateBy);

	public abstract List findByChcDueId(Object chcDueId);

	public abstract List findByChcDueTo(Object chcDueTo);

	public abstract List findByChcStatus(Object chcStatus);

	public abstract List findAll();

	public abstract SalChance merge(SalChance detachedInstance);

	public abstract void attachDirty(SalChance instance);

	public abstract void attachClean(SalChance instance);
	
	
	public abstract boolean delete(Long chcId);
	public abstract List findPropertyList(String custName,String chcTitle,String chcLinkman,int pageSize,int transmitPage,Long userRoleID,Long usrID,String chcStatus);
	public abstract Long findPropertyCount(String custName,String chcTitle,String chcLinkman,int pageSize,int transmitPage,Long userRoleID,Long usrID,String chcStatus);
	public abstract boolean saveOrUpdate(SalChance transientInstance);
	public abstract boolean updDispatch(SalChance salChanceObject);
	public abstract boolean loseSalChance(SalChance salChanceObject);
	public abstract boolean successSalChance(SalChance salChanceObject) ;
}