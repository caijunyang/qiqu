package com.bootdo.ofo.domain;

public class HbUserCash {
    private String userId;

    private Double userCash;

    private Integer userCashType;

    private Integer userCashStatus;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Double getUserCash() {
        return userCash;
    }

    public void setUserCash(Double userCash) {
        this.userCash = userCash;
    }

    public Integer getUserCashType() {
        return userCashType;
    }

    public void setUserCashType(Integer userCashType) {
        this.userCashType = userCashType;
    }

    public Integer getUserCashStatus() {
        return userCashStatus;
    }

    public void setUserCashStatus(Integer userCashStatus) {
        this.userCashStatus = userCashStatus;
    }
}