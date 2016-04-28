package com.crm.biz;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import com.crm.biz.impl.ISysUserService;
import com.crm.dao.SysUserDAO;
import com.crm.dao.impl.ISysRoleDAO;
import com.crm.dao.impl.ISysUserDAO;
import com.crm.entity.SysRight;
import com.crm.entity.SysRole;
import com.crm.entity.SysRoleRight;
import com.crm.entity.SysUser;
import com.crm.util.PageModel;
import com.crm.view.LoginView;


public class SysUserService implements java.io.Serializable, ISysUserService {
	private ISysUserDAO sysUserDAO;
	private ISysRoleDAO sysRoleDAO;

	public void setSysRoleDAO(ISysRoleDAO sysRoleDAO) {
		this.sysRoleDAO = sysRoleDAO;
	}

	public void setSysUserDAO(ISysUserDAO sysUserDAO) {
		this.sysUserDAO = sysUserDAO;
	}
	//查询所有用户
	public List<SysUser> sel() {
		return sysUserDAO.findAll();
	}
	public LoginView findByUserNoAndPassWord(String UserNo,String pwd){
		LoginView loginViewObject = null;
		
		SysUser sysUserObject = sysUserDAO.findByUserNoAndPassWord(UserNo, pwd);
		if (sysUserObject!=null) {
			loginViewObject =new LoginView();
			StringBuilder sb=new StringBuilder();
			 SysRole sysRole = sysRoleDAO.findById(sysUserObject.getUsrRoleId());
			 Set<SysRoleRight> SysRoleRightSet=sysRole.getSysRoleRights();
				Iterator<SysRoleRight> iterator = SysRoleRightSet.iterator();
				while(iterator.hasNext()){
					SysRoleRight srr=iterator.next();
					SysRight sRight = srr.getSysRight();
					String parent ="";
					if(sRight.getRightParentCode().equals("ROOT_MENU")){
						parent = "l2ID";
					}else{
						parent = sRight.getRightParentCode();
					}
					sb.append(sRight.getRightCode()+"= theMenu.addChild("
							+parent+",\"" + sRight.getRightType()+"\",\""
							+sRight.getRightText() + "\",\"" + sRight.getRightUrl()
							+"\",\"" + sRight.getRightTip()+"\");\r\n");
				}
				loginViewObject.setMenuString(sb.toString());
				System.out.println(sysUserObject.getUsrId());
				loginViewObject.setUsrId(sysUserObject.getUsrId());
				loginViewObject.setUsrName(sysUserObject.getUsrName());
				loginViewObject.setRoleName(sysRole.getRoleName());
				loginViewObject.setUsrRoleId(sysRole.getRoleId());
				System.out.println(loginViewObject.getMenuString());
		}
/*		right_code                                         right_parent_code                                  right_type           right_text                                         right_url                                                                                            right_tip                                          right_update_datetime
		-------------------------------------------------- -------------------------------------------------- -------------------- -------------------------------------------------- ---------------------------------------------------------------------------------------------------- -------------------------------------------------- ---------------------
		L01                                                ROOT_MENU                                          Folder               营销管理                                                                                                                                                    营销管理                                               2014-11-22
		l2ID = theMenu.addEntry(-1, "Folder", "客户关系管理系统", "mywork.jsp", "客户关系管理系统");
		 ${loginViewObject.menuString}*/
		 return loginViewObject;/*	
		List<LoginViewss> LoginViewObjectList = sysUserDAO.getUserForLogin(userNo, pwd);
		for (LoginViewss loginView : LoginViewObjectList) {
			System.out.println(loginView);
		}*/
	}
	
	public List<SysUser> getSysUserObjectList(){
		return sysUserDAO.findAll();
	}
	
	public SysUser getSysUserByID(Long id){
		return sysUserDAO.findById(id);
		
	}

	public List<SysUser> fillAll(){
		return sysUserDAO.fillAll();
	}
	public List<SysUser> getUserAll() {
		return sysUserDAO.findAll();
	}
	public void addUser(SysUser sysUserObject){
		sysUserDAO.save(sysUserObject);
		
	}
	public  List<SysUser> getfindAllList(){
		return sysUserDAO.findAllList();
	}
	public void delUserById(SysUser sysUser){
		sysUserDAO.delete(sysUser);
	}

	public void updUserByRoleID(SysUser sysUserObject) {
		// TODO Auto-generated method stub
		sysUserDAO.updUserByRoleID(sysUserObject);
	}
	public  void deleteByUserID(SysUser sysUserObject){
		sysUserDAO.deleteByUserID(sysUserObject);
	}

	public PageModel<SysUser> getSysUserPageModel(SysUser sysUser,int page,int pageSize) {
		// TODO Auto-generated method stub
		return sysUserDAO.getPageModel(sysUser, page, pageSize);
	}

}