package com.crm.biz.impl;

import java.util.List;

import com.crm.entity.SalChance;
import com.crm.entity.SalPlan;

public interface ISalPlanService {
	public abstract List<SalPlan> findAllSalPlan();
	public abstract List<SalPlan> getSalPlanByID(Long chcId);
	public abstract void addSalPlan(SalPlan salPlan);
	public void updateSalPlan(SalPlan salPlan);
}