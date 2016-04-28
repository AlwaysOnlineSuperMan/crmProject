package com.crm.biz.impl;

import java.util.List;

import com.crm.entity.CstLost;

public interface ICstLostService {
	public abstract List<CstLost> getCstLostAll() throws Exception;
	public abstract CstLost getByCustName(String lstCustName) throws Exception;
	public abstract CstLost getById(Long lsId) throws Exception;
	public abstract void saveOrUpdate(CstLost cstLost) throws Exception;
}