package com.crm.biz;

import java.util.List;

import com.crm.biz.impl.ISysRoleService;
import com.crm.dao.impl.ISysRoleDAO;
import com.crm.entity.SysRole;
import com.crm.entity.SysUser;
import com.crm.util.PageModel;


public class SysRoleService implements java.io.Serializable, ISysRoleService {
	private ISysRoleDAO sysRoleDAO ;

	public void setSysRoleDAO(ISysRoleDAO sysRoleDAO) {
		this.sysRoleDAO = sysRoleDAO;
	}
	
	public SysRole findByID(Long roleId){
		return sysRoleDAO.findById(roleId);
	}
	public List<SysRole> getSysRoleAll(){
		return sysRoleDAO.findAll();
	}
	public void addRole(SysRole sysRole){
		sysRoleDAO.save(sysRole);
	}

	public void delRole(Long roleId) throws Exception {
		if(sysRoleDAO.delete(roleId)){
			
		}
		
		
	}
	public PageModel<SysRole> getPageModel(SysRole sysRole,int page,int pageSize)throws Exception{
		return sysRoleDAO.getPageModel(sysRole, page, pageSize);
	}
	
}