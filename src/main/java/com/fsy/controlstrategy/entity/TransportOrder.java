package com.fsy.controlstrategy.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class TransportOrder {
    private Integer id;

    private String supperlier;

    private String licenseNumber;

    private Integer orderNumber;

    private String items;

    private String specification;

    private BigDecimal roughWeight;

    private BigDecimal suttle;

    private BigDecimal unitPrice;

    private BigDecimal totalAmountOrder;

    private String reportYear;

    private String supplierStation;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderDate;

    private Byte valid;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSupperlier() {
        return supperlier;
    }

    public void setSupperlier(String supperlier) {
        this.supperlier = supperlier == null ? null : supperlier.trim();
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber == null ? null : licenseNumber.trim();
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
        this.items = items == null ? null : items.trim();
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification == null ? null : specification.trim();
    }

    public BigDecimal getRoughWeight() {
        return roughWeight;
    }

    public void setRoughWeight(BigDecimal roughWeight) {
        this.roughWeight = roughWeight;
    }

    public BigDecimal getSuttle() {
        return suttle;
    }

    public void setSuttle(BigDecimal suttle) {
        this.suttle = suttle;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getTotalAmountOrder() {
        return totalAmountOrder;
    }

    public void setTotalAmountOrder(BigDecimal totalAmountOrder) {
        this.totalAmountOrder = totalAmountOrder;
    }

    public String getReportYear() {
        return reportYear;
    }

    public void setReportYear(String reportYear) {
        this.reportYear = reportYear == null ? null : reportYear.trim();
    }

    public String getSupplierStation() {
        return supplierStation;
    }

    public void setSupplierStation(String supplierStation) {
        this.supplierStation = supplierStation == null ? null : supplierStation.trim();
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Byte getValid() {
        return valid;
    }

    public void setValid(Byte valid) {
        this.valid = valid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}