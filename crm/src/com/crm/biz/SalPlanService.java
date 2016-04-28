package com.crm.biz;

import java.util.List;

import com.crm.biz.impl.ISalPlanService;
import com.crm.dao.impl.ISalPlanDAO;
import com.crm.entity.SalChance;
import com.crm.entity.SalPlan;


public class SalPlanService implements java.io.Serializable, ISalPlanService {
	private ISalPlanDAO salPlanDAO;


	public void setSalPlanDAO(ISalPlanDAO salPlanDAO) {
		this.salPlanDAO = salPlanDAO;
	}
	
	public List<SalPlan> findAllSalPlan(){
		List<SalPlan> salChanceObjectList = salPlanDAO.findAll();
		return salChanceObjectList;
	}

	public List<SalPlan> getSalPlanByID(Long chcId) {
		// TODO Auto-generated method stub
		return salPlanDAO.getById(chcId);
	}

	
	public void addSalPlan(SalPlan salPlan){
		salPlanDAO.save(salPlan);
		//salPlanDAO.addSave(salPlan);
	}
	public void updateSalPlan(SalPlan salPlan){
		salPlanDAO.updateSalPlan(salPlan);
	}
}