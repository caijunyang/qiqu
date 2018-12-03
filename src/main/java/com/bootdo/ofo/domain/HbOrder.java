package com.bootdo.ofo.domain;

import java.util.Date;

public class HbOrder {
    private String orderId;

    private String orderUserid;

    private Double orderPrice;

    private Date orderCreatetime;

    private Integer orderType;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getOrderUserid() {
        return orderUserid;
    }

    public void setOrderUserid(String orderUserid) {
        this.orderUserid = orderUserid == null ? null : orderUserid.trim();
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Date getOrderCreatetime() {
        return orderCreatetime;
    }

    public void setOrderCreatetime(Date orderCreatetime) {
        this.orderCreatetime = orderCreatetime;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }
}