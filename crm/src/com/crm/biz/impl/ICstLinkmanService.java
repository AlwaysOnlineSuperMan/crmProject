package com.crm.biz.impl;

import java.util.List;

import com.crm.entity.CstLinkman;

public interface ICstLinkmanService {
	 public abstract List<CstLinkman> getByNo(String custNo)throws Exception;
	 public abstract CstLinkman getById(Long Id)throws Exception;
	 public abstract void delById(Long lkmId) throws Exception;
	 public abstract void saveOrUpd(CstLinkman cst) throws Exception;
	 public  abstract void Update(CstLinkman cst) throws Exception;
}