package com.huabang.ofo.domain;

import java.util.Date;

public class HbRecord {
    private Integer recordId;

    private Integer recordUserid;

    private Integer recordType;

    private String recordMessage;

    private Date recordCreatetime;

    private String recordImage;

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getRecordUserid() {
        return recordUserid;
    }

    public void setRecordUserid(Integer recordUserid) {
        this.recordUserid = recordUserid;
    }

    public Integer getRecordType() {
        return recordType;
    }

    public void setRecordType(Integer recordType) {
        this.recordType = recordType;
    }

    public String getRecordMessage() {
        return recordMessage;
    }

    public void setRecordMessage(String recordMessage) {
        this.recordMessage = recordMessage == null ? null : recordMessage.trim();
    }

    public Date getRecordCreatetime() {
        return recordCreatetime;
    }

    public void setRecordCreatetime(Date recordCreatetime) {
        this.recordCreatetime = recordCreatetime;
    }

    public String getRecordImage() {
        return recordImage;
    }

    public void setRecordImage(String recordImage) {
        this.recordImage = recordImage == null ? null : recordImage.trim();
    }
}