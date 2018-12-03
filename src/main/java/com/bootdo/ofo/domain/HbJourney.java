package com.bootdo.ofo.domain;

import java.util.Date;

public class HbJourney {
    private String journeyId;

    private String journeyUserid;

    private String journeyShareid;

    private Integer journeyTime;

    private Double journeyMoney;

    private Double journeyDistance;

    private String journeyStartpot;

    private String journeyEndpot;

    private Date journeyCreatetime;

    private Date journeyEndtime;

    public String getJourneyId() {
        return journeyId;
    }

    public void setJourneyId(String journeyId) {
        this.journeyId = journeyId == null ? null : journeyId.trim();
    }

    public String getJourneyUserid() {
        return journeyUserid;
    }

    public void setJourneyUserid(String journeyUserid) {
        this.journeyUserid = journeyUserid == null ? null : journeyUserid.trim();
    }

    public String getJourneyShareid() {
        return journeyShareid;
    }

    public void setJourneyShareid(String journeyShareid) {
        this.journeyShareid = journeyShareid == null ? null : journeyShareid.trim();
    }

    public Integer getJourneyTime() {
        return journeyTime;
    }

    public void setJourneyTime(Integer journeyTime) {
        this.journeyTime = journeyTime;
    }

    public Double getJourneyMoney() {
        return journeyMoney;
    }

    public void setJourneyMoney(Double journeyMoney) {
        this.journeyMoney = journeyMoney;
    }

    public Double getJourneyDistance() {
        return journeyDistance;
    }

    public void setJourneyDistance(Double journeyDistance) {
        this.journeyDistance = journeyDistance;
    }

    public String getJourneyStartpot() {
        return journeyStartpot;
    }

    public void setJourneyStartpot(String journeyStartpot) {
        this.journeyStartpot = journeyStartpot == null ? null : journeyStartpot.trim();
    }

    public String getJourneyEndpot() {
        return journeyEndpot;
    }

    public void setJourneyEndpot(String journeyEndpot) {
        this.journeyEndpot = journeyEndpot == null ? null : journeyEndpot.trim();
    }

    public Date getJourneyCreatetime() {
        return journeyCreatetime;
    }

    public void setJourneyCreatetime(Date journeyCreatetime) {
        this.journeyCreatetime = journeyCreatetime;
    }

    public Date getJourneyEndtime() {
        return journeyEndtime;
    }

    public void setJourneyEndtime(Date journeyEndtime) {
        this.journeyEndtime = journeyEndtime;
    }
}