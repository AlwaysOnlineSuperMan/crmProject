package com.crm.entity;

import java.sql.Timestamp;

/**
 * SysUser entity. @author MyEclipse Persistence Tools
 */

public class SysUser implements java.io.Serializable {

	// Fields

	private Long usrId;
	private String usrNo;
	private String usrName;
	private String usrPassword;
	private Long usrRoleId;
	private String usrRoleName;
	private Integer usrFlag;
	private Timestamp usrUpdateDatetime;
	public String getUsrRoleName() {
		return usrRoleName;
	}

	public void setUsrRoleName(String usrRoleName) {
		this.usrRoleName = usrRoleName;
	}

	/*private SysRole sysRole;*/

	// Constructors

	/** default constructor */
	public SysUser() {
	}

	/** minimal constructor */
	public SysUser(String usrName, String usrPassword, Integer usrFlag) {
		this.usrName = usrName;
		this.usrPassword = usrPassword;
		this.usrFlag = usrFlag;
	}

	/** full constructor */
	public SysUser(String usrNo, String usrName, String usrPassword,
			Long usrRoleId, Integer usrFlag, Timestamp usrUpdateDatetime) {
		this.usrNo = usrNo;
		this.usrName = usrName;
		this.usrPassword = usrPassword;
		this.usrRoleId = usrRoleId;
		this.usrFlag = usrFlag;
		this.usrUpdateDatetime = usrUpdateDatetime;
	}

	// Property accessors

	public Long getUsrId() {
		return this.usrId;
	}

	public void setUsrId(Long usrId) {
		this.usrId = usrId;
	}

	public String getUsrNo() {
		return this.usrNo;
	}

	public void setUsrNo(String usrNo) {
		this.usrNo = usrNo;
	}

	public String getUsrName() {
		return this.usrName;
	}

	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}

	public String getUsrPassword() {
		return this.usrPassword;
	}

	public void setUsrPassword(String usrPassword) {
		this.usrPassword = usrPassword;
	}

	public Long getUsrRoleId() {
		return this.usrRoleId;
	}

	public void setUsrRoleId(Long usrRoleId) {
		this.usrRoleId = usrRoleId;
	}

	public Integer getUsrFlag() {
		return this.usrFlag;
	}

	public void setUsrFlag(Integer usrFlag) {
		this.usrFlag = usrFlag;
	}

	public Timestamp getUsrUpdateDatetime() {
		return this.usrUpdateDatetime;
	}

	public void setUsrUpdateDatetime(Timestamp usrUpdateDatetime) {
		this.usrUpdateDatetime = usrUpdateDatetime;
	}

	@Override
	public String toString() {
		return "SysUser [usrFlag=" + usrFlag + ", usrId=" + usrId
				+ ", usrName=" + usrName + ", usrNo=" + usrNo
				+ ", usrPassword=" + usrPassword + ", usrRoleId=" + usrRoleId
				+ ", usrUpdateDatetime=" + usrUpdateDatetime + "]";
	}

}