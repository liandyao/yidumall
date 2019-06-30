package com.yidu.order.entity;

import java.math.BigDecimal;
import java.util.Date;

public class YiduOrders {
    private String ordersId;

    private String userId;

    private String addressId;

    private String ordersCode;

    private Integer ordersNumber;

    private String ordersDate;

    private BigDecimal ordersSummoney;

    private Integer ordersState;

    private Integer isva;

    private Date optime;

    private String oper;

    private Integer sort;

    private String proId; //商品id

    private YiduProduct product ; //订单中的商品对象

    public YiduProduct getProduct() {
        return product;
    }

    public void setProduct(YiduProduct product) {
        this.product = product;
    }




    public String getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(String ordersId) {
        this.ordersId = ordersId == null ? null : ordersId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId == null ? null : addressId.trim();
    }

    public String getOrdersCode() {
        return ordersCode;
    }

    public void setOrdersCode(String ordersCode) {
        this.ordersCode = ordersCode == null ? null : ordersCode.trim();
    }

    public Integer getOrdersNumber() {
        return ordersNumber;
    }

    public void setOrdersNumber(Integer ordersNumber) {
        this.ordersNumber = ordersNumber;
    }

    public String getOrdersDate() {
        return ordersDate;
    }

    public void setOrdersDate(String ordersDate) {
        this.ordersDate = ordersDate == null ? null : ordersDate.trim();
    }

    public BigDecimal getOrdersSummoney() {
        return ordersSummoney;
    }

    public void setOrdersSummoney(BigDecimal ordersSummoney) {
        this.ordersSummoney = ordersSummoney;
    }

    public Integer getOrdersState() {
        return ordersState;
    }

    public void setOrdersState(Integer ordersState) {
        this.ordersState = ordersState;
    }

    public Integer getIsva() {
        return isva;
    }

    public void setIsva(Integer isva) {
        this.isva = isva;
    }

    public Date getOptime() {
        return optime;
    }

    public void setOptime(Date optime) {
        this.optime = optime;
    }

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper == null ? null : oper.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId == null ? null : proId.trim();
    }
}