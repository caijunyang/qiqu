package com.huabang.ofo.domain;

public class HbUserCash {
    private String userId;

    private Double userCash;
    
    private String userAccountMoney;

    private Integer userCashType;

    private Integer userCashStatus;
    private String orderidWeix;
    
    
    public String getOrderidWeix() {
		return orderidWeix;
	}

	public void setOrderidWeix(String orderidWeix) {
		this.orderidWeix = orderidWeix;
	}

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

	public String getUserAccountMoney() {
		return userAccountMoney;
	}

	public void setUserAccountMoney(String userAccountMoney) {
		this.userAccountMoney = userAccountMoney;
	}

	
}