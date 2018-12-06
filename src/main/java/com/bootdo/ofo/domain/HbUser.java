package com.bootdo.ofo.domain;

import java.util.Date;

public class HbUser {
    private String userId;

    private String userName;

    private String userPhone;

    private String userImage;

    private String userSex;

    private Date userBirthday;

    private Integer userApprove;

    private Integer userStatus;

    private String userWeixin;

    private String userQq;

    private Integer userXyapprove;

    private Integer userInvite;

    private Double accountTotel;
    

	public Double getAccountTotel() {
		return accountTotel;
	}

	public void setAccountTotel(Double accountTotel) {
		this.accountTotel = accountTotel;
	}

	public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage == null ? null : userImage.trim();
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex == null ? null : userSex.trim();
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public Integer getUserApprove() {
        return userApprove;
    }

    public void setUserApprove(Integer userApprove) {
        this.userApprove = userApprove;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserWeixin() {
        return userWeixin;
    }

    public void setUserWeixin(String userWeixin) {
        this.userWeixin = userWeixin == null ? null : userWeixin.trim();
    }

    public String getUserQq() {
        return userQq;
    }

    public void setUserQq(String userQq) {
        this.userQq = userQq == null ? null : userQq.trim();
    }

    public Integer getUserXyapprove() {
        return userXyapprove;
    }

    public void setUserXyapprove(Integer userXyapprove) {
        this.userXyapprove = userXyapprove;
    }

    public Integer getUserInvite() {
        return userInvite;
    }

    public void setUserInvite(Integer userInvite) {
        this.userInvite = userInvite;
    }
}