package com.crm.dao.impl;

import java.util.List;

import com.crm.entity.BasDict;
import com.crm.entity.CstCustomer;

public interface ICstCustomerDAO {

	public abstract void save(CstCustomer transientInstance);
	
	public abstract void saveOrUpdate(CstCustomer transientInstance);
	public abstract List<CstCustomer> getcstcustname(java.lang.String name);
	
	public abstract void OrUpdate(CstCustomer transientInstance);
	
	public abstract void delete(CstCustomer persistentInstance);

	public abstract CstCustomer findById(java.lang.String id);
	
	public abstract void delByNo(String custNo);

	public abstract List findByExample(CstCustomer instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByCustName(Object custName);

	public abstract List findByCustRegion(Object custRegion);

	public abstract List findByCustManagerId(Object custManagerId);

	public abstract List findByCustManagerName(Object custManagerName);

	public abstract List findByCustLevel(Object custLevel);

	public abstract List findByCustLevelLabel(Object custLevelLabel);

	public abstract List findByCustSatisfy(Object custSatisfy);

	public abstract List findByCustCredit(Object custCredit);

	public abstract List findByCustAddr(Object custAddr);

	public abstract List findByCustZip(Object custZip);

	public abstract List findByCustTel(Object custTel);

	public abstract List findByCustFax(Object custFax);

	public abstract List findByCustWebsite(Object custWebsite);

	public abstract List findByCustLicenceNo(Object custLicenceNo);

	public abstract List findByCustChieftain(Object custChieftain);

	public abstract List findByCustBankroll(Object custBankroll);

	public abstract List findByCustTurnover(Object custTurnover);

	public abstract List findByCustBank(Object custBank);

	public abstract List findByCustBankAccount(Object custBankAccount);

	public abstract List findByCustLocalTaxNo(Object custLocalTaxNo);

	public abstract List findByCustNationalTaxNo(Object custNationalTaxNo);

	public abstract List findByCustStatus(Object custStatus);

	public abstract List findAll();

	public abstract CstCustomer merge(CstCustomer detachedInstance);

	public abstract void attachDirty(CstCustomer instance);

	public abstract void attachClean(CstCustomer instance);
	public abstract CstCustomer findByNo(String custNo);
	public abstract String getNewCustNo();


}