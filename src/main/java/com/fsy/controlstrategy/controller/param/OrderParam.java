package com.fsy.controlstrategy.controller.param;

import java.io.Serializable;

public class OrderParam implements Serializable {

    private String startDate;
    private String endDate;
    private Integer orderNumber;
    private String supplierStation;
    private String items;
    private Integer limit;
    private Integer offset;
    private String lastUt;
    private Long lastId;
    private String currentDate;

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public String getSupplierStation() {
        return supplierStation;
    }

    public void setSupplierStation(String supplierStation) {
        this.supplierStation = supplierStation;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getLastUt() {
        return lastUt;
    }

    public void setLastUt(String lastUt) {
        this.lastUt = lastUt;
    }

    public Long getLastId() {
        return lastId;
    }

    public void setLastId(Long lastId) {
        this.lastId = lastId;
    }
}
