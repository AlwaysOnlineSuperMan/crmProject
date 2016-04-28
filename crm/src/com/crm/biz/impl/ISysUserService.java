package com.crm.biz.impl;

import java.util.List;

import com.crm.entity.SysUser;
import com.crm.util.PageModel;
import com.crm.view.LoginView;

public interface ISysUserService {
	public abstract LoginView findByUserNoAndPassWord(String UserNo,String pwd);
	public abstract List<SysUser> getSysUserObjectList();
	public abstract SysUser getSysUserByID(Long id);
	public abstract List<SysUser> fillAll();
	public abstract List<SysUser> getUserAll();
	public abstract List<SysUser> sel();
	public abstract void addUser(SysUser sysUserObject);
	public abstract  List<SysUser> getfindAllList();
	public abstract void delUserById(SysUser sysUser);
	public abstract void updUserByRoleID(SysUser sysUserObject);
	public abstract void deleteByUserID(SysUser sysUserObject);
	public PageModel<SysUser> getSysUserPageModel(SysUser sysUser,int page,int pageSize);
}