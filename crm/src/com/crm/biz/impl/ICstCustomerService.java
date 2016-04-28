package com.crm.biz.impl;

import java.util.List;

import com.crm.entity.BasDict;
import com.crm.entity.CstCustomer;

public interface ICstCustomerService {
	public abstract List<CstCustomer> getCstCustomerList() throws Exception;
	public abstract CstCustomer getCustNo(String custNo) throws Exception;

	public abstract CstCustomer getUsers(String uid) throws Exception;

	public abstract void saveOrUpdate(CstCustomer cstCustomer) throws Exception;
	public abstract void addCustomer(CstCustomer cstCustomer) throws Exception;

	public abstract void delByNo(String custNo) throws Exception;
	
	public abstract CstCustomer getCstCustomerId(Long id) throws Exception;
	public abstract List<CstCustomer> getcstcustName(String name);
}