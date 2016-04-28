package com.hr.entity;

import java.util.Date;

public class Users {
    private Short uId;

    private String uName;

    private String uTrueName;

    private String uPassword;

    private Short uRoleId;

    private Date updateDatetime;

    public Short getuId() {
        return uId;
    }

    public void setuId(Short uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName == null ? null : uName.trim();
    }

    public String getuTrueName() {
        return uTrueName;
    }

    public void setuTrueName(String uTrueName) {
        this.uTrueName = uTrueName == null ? null : uTrueName.trim();
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword == null ? null : uPassword.trim();
    }

    public Short getuRoleId() {
        return uRoleId;
    }

    public void setuRoleId(Short uRoleId) {
        this.uRoleId = uRoleId;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }
}