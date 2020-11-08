package com.fsy.controlstrategy.controller.param;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TransportOrderParam implements Serializable {

    private String licenseNumber;

    private Integer orderNumber;

    private String items;

    private BigDecimal unitPrice;

    private String supplierStation;

    private Date orderDate;

    private Date startTime;

    private Date endTime;

    private String reportYear;

    public String getReportYear() {
        return reportYear;
    }

    public void setReportYear(String reportYear) {
        this.reportYear = reportYear;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
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

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }


    public String getSupplierStation() {
        return supplierStation;
    }

    public void setSupplierStation(String supplierStation) {
        this.supplierStation = supplierStation;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
