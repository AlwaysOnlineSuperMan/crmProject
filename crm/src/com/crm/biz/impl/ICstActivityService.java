package com.crm.biz.impl;

import java.util.List;

import com.crm.entity.CstActivity;
import com.crm.entity.CstLinkman;

public interface ICstActivityService {
	public abstract List<CstActivity> getByNo(String custNo)throws Exception;
	public abstract CstActivity getById(Long Id)throws Exception;
	public abstract void delById(Long lkmId)throws Exception ;
	public abstract void saveOrUpd(CstActivity cst)throws Exception;
	public  abstract void Update(CstActivity cst)throws Exception;
}