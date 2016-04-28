package com.crm.dao.impl;

import java.util.List;

import com.crm.entity.SalPlan;

public interface ISalPlanDAO {

	public abstract void save(SalPlan transientInstance);

	public abstract void delete(SalPlan persistentInstance);

	public abstract SalPlan findById(java.lang.Long id);

	public abstract List findByExample(SalPlan instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByPlaTodo(Object plaTodo);

	public abstract List findByPlaResult(Object plaResult);

	public abstract List findAll();

	public abstract SalPlan merge(SalPlan detachedInstance);

	public abstract void attachDirty(SalPlan instance);

	public abstract void attachClean(SalPlan instance);
	public abstract List<SalPlan> getById(Long chcId) ;
	public abstract boolean addSave(SalPlan salPlan) ;
	public abstract boolean updateSalPlan(SalPlan salPlan);
}