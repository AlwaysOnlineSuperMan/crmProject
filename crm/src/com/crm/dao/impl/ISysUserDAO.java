package com.crm.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.crm.entity.SysUser;
import com.crm.util.PageModel;

public interface ISysUserDAO {

	public abstract void save(SysUser transientInstance);

	public abstract void delete(SysUser persistentInstance);

	public abstract SysUser findById(java.lang.Long id);

	public abstract List findByExample(SysUser instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByUsrNo(Object usrNo);

	public abstract List findByUsrName(Object usrName);

	public abstract List findByUsrPassword(Object usrPassword);

	public abstract List findByUsrRoleId(Object usrRoleId);

	public abstract List findByUsrFlag(Object usrFlag);

	public abstract List findAll();

	public abstract SysUser merge(SysUser detachedInstance);

	public abstract void attachDirty(SysUser instance);

	public abstract void attachClean(SysUser instance);
	public abstract SysUser findByUserNoAndPassWord(String userNo, String passWord);

	public abstract List<SysUser> fillAll();
	//查出所有用户
	public abstract List<SysUser> sel();
	public abstract List findAllList();
	public abstract void updUserByRoleID(SysUser sysUserObject);
	public abstract boolean deleteByUserID(SysUser sysUserObject);
	public abstract PageModel<SysUser> getPageModel(SysUser sysUser, int page,int pageSize);
}