package com.bootdo.ofo.domain;

import java.util.Date;

public class HbMessage {
    private Integer messId;

    private String messName;

    private String messSimpleness;

    private String messMessage;

    private String messDetails;

    private String messJbdetails;

    private String messPolice;

    private Integer messPolicePhone;

    private Date messCreatetime;

    public Integer getMessId() {
        return messId;
    }

    public void setMessId(Integer messId) {
        this.messId = messId;
    }

    public String getMessName() {
        return messName;
    }

    public void setMessName(String messName) {
        this.messName = messName == null ? null : messName.trim();
    }

    public String getMessSimpleness() {
        return messSimpleness;
    }

    public void setMessSimpleness(String messSimpleness) {
        this.messSimpleness = messSimpleness == null ? null : messSimpleness.trim();
    }

    public String getMessMessage() {
        return messMessage;
    }

    public void setMessMessage(String messMessage) {
        this.messMessage = messMessage == null ? null : messMessage.trim();
    }

    public String getMessDetails() {
        return messDetails;
    }

    public void setMessDetails(String messDetails) {
        this.messDetails = messDetails == null ? null : messDetails.trim();
    }

    public String getMessJbdetails() {
        return messJbdetails;
    }

    public void setMessJbdetails(String messJbdetails) {
        this.messJbdetails = messJbdetails == null ? null : messJbdetails.trim();
    }

    public String getMessPolice() {
        return messPolice;
    }

    public void setMessPolice(String messPolice) {
        this.messPolice = messPolice == null ? null : messPolice.trim();
    }

    public Integer getMessPolicePhone() {
        return messPolicePhone;
    }

    public void setMessPolicePhone(Integer messPolicePhone) {
        this.messPolicePhone = messPolicePhone;
    }

    public Date getMessCreatetime() {
        return messCreatetime;
    }

    public void setMessCreatetime(Date messCreatetime) {
        this.messCreatetime = messCreatetime;
    }
}