package com.huabang.ofo.domain;

import java.util.Date;

public class HbOrder {
    private String orderId;
    private String order_status;
    private String orderUserid;
    
    private String orderCashId;

    private Double orderPrice;

    private Date orderCreatetime;

    private Integer orderType;

    public String getOrderId() {
        return orderId;
    }

    public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
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

	public String getOrderCashId() {
		return orderCashId;
	}

	public void setOrderCashId(String orderCashId) {
		this.orderCashId = orderCashId;
	}
}