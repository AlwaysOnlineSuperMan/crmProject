package com.hr.entity;

import java.util.Date;

public class ConfigMajorKind {
    private Short mfkId;

    private String majorKindName;

    private String majorKindId;

    private Date updateDatetime;

    public Short getMfkId() {
        return mfkId;
    }

    public void setMfkId(Short mfkId) {
        this.mfkId = mfkId;
    }

    public String getMajorKindName() {
        return majorKindName;
    }

    public void setMajorKindName(String majorKindName) {
        this.majorKindName = majorKindName == null ? null : majorKindName.trim();
    }

    public String getMajorKindId() {
        return majorKindId;
    }

    public void setMajorKindId(String majorKindId) {
        this.majorKindId = majorKindId == null ? null : majorKindId.trim();
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }
}