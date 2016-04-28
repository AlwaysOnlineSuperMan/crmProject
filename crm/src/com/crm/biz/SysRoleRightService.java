package com.crm.biz;

import com.crm.biz.impl.ISysRoleRightService;
import com.crm.dao.impl.ISysRightDAO;


public class SysRoleRightService implements java.io.Serializable, ISysRoleRightService {
	private ISysRightDAO  sysRightDAO ;

	public void setSysRightDAO(ISysRightDAO sysRightDAO) {
		this.sysRightDAO = sysRightDAO;
	}
	
}