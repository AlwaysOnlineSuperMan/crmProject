package com.crm.view;

import java.sql.Timestamp;

public class LoginView {
	

	private Long usrId;
	private String usrNo;
	private String usrName;
	private String usrPassword;
	private Long usrRoleId;
	private Integer usrFlag;
	private String MenuString;
	public String getMenuString() {
		return MenuString;
	}

	public void setMenuString(String menuString) {
		MenuString = menuString;
	}
	private Timestamp usrUpdateDatetime;
	
	private String roleName;

	public Long getUsrId() {
		return usrId;
	}

	public void setUsrId(Long usrId) {
		this.usrId = usrId;
	}

	public String getUsrNo() {
		return usrNo;
	}

	public void setUsrNo(String usrNo) {
		this.usrNo = usrNo;
	}

	public String getUsrName() {
		return usrName;
	}

	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}

	public String getUsrPassword() {
		return usrPassword;
	}

	public void setUsrPassword(String usrPassword) {
		this.usrPassword = usrPassword;
	}

	public Long getUsrRoleId() {
		return usrRoleId;
	}

	public void setUsrRoleId(Long usrRoleId) {
		this.usrRoleId = usrRoleId;
	}

	public Integer getUsrFlag() {
		return usrFlag;
	}

	public void setUsrFlag(Integer usrFlag) {
		this.usrFlag = usrFlag;
	}

	public Timestamp getUsrUpdateDatetime() {
		return usrUpdateDatetime;
	}

	public void setUsrUpdateDatetime(Timestamp usrUpdateDatetime) {
		this.usrUpdateDatetime = usrUpdateDatetime;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	@Override
	public String toString() {
		return "LoginView [roleName=" + roleName + ", usrFlag=" + usrFlag
				+ ", usrId=" + usrId + ", usrName=" + usrName + ", usrNo="
				+ usrNo + ", usrPassword=" + usrPassword + ", usrRoleId="
				+ usrRoleId + ", usrUpdateDatetime=" + usrUpdateDatetime + "]";
	}  
}
