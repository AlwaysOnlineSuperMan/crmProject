package com.crm.biz;

import com.crm.biz.impl.ISysRightService;
import com.crm.dao.impl.ISysRightDAO;


public class SysRightService implements java.io.Serializable, ISysRightService {
	private ISysRightDAO sysRightDAO;

	public void setSysRightDAO(ISysRightDAO sysRightDAO) {
		this.sysRightDAO = sysRightDAO;
	}
	

}