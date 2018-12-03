package com.huabang.ofo.domain;

public class HbAccount {
    private Integer accountId;

    private String accountUserId;

    private String accountTotel;
    private Double account_totel;

    private Integer accountStatus;

    private Double accountPay;

    private Double accountPresented;

    
    public Double getAccount_totel() {
		return account_totel;
	}

	public void setAccount_totel(Double account_totel) {
		this.account_totel = account_totel;
	}

	public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getAccountUserId() {
        return accountUserId;
    }

    public void setAccountUserId(String accountUserId) {
        this.accountUserId = accountUserId == null ? null : accountUserId.trim();
    }

    public String getAccountTotel() {
        return accountTotel;
    }

    public void setAccountTotel(String accountTotel) {
        this.accountTotel = accountTotel == null ? null : accountTotel.trim();
    }

    public Integer getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(Integer accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Double getAccountPay() {
        return accountPay;
    }

    public void setAccountPay(Double accountPay) {
        this.accountPay = accountPay;
    }

    public Double getAccountPresented() {
        return accountPresented;
    }

    public void setAccountPresented(Double accountPresented) {
        this.accountPresented = accountPresented;
    }
}