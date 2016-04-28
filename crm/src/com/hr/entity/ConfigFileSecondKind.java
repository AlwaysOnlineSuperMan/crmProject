package com.hr.entity;

import java.util.Date;

public class ConfigFileSecondKind {
    private Short fskId;

    private Short firstKindId;

    private String firstKindName;

    private String secondKindId;

    private String secondKindName;

    private Date updateDatetime;

    public Short getFskId() {
        return fskId;
    }

    public void setFskId(Short fskId) {
        this.fskId = fskId;
    }

    public Short getFirstKindId() {
        return firstKindId;
    }

    public void setFirstKindId(Short firstKindId) {
        this.firstKindId = firstKindId;
    }

    public String getFirstKindName() {
        return firstKindName;
    }

    public void setFirstKindName(String firstKindName) {
        this.firstKindName = firstKindName == null ? null : firstKindName.trim();
    }

    public String getSecondKindId() {
        return secondKindId;
    }

    public void setSecondKindId(String secondKindId) {
        this.secondKindId = secondKindId == null ? null : secondKindId.trim();
    }

    public String getSecondKindName() {
        return secondKindName;
    }

    public void setSecondKindName(String secondKindName) {
        this.secondKindName = secondKindName == null ? null : secondKindName.trim();
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }
}