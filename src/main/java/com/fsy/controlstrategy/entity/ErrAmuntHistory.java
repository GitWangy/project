package com.fsy.controlstrategy.entity;

import java.math.BigDecimal;

public class ErrAmuntHistory {
    private Long id;

    private Long transportId;

    private BigDecimal transportErrAmount;

    private BigDecimal transportOkAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTransportId() {
        return transportId;
    }

    public void setTransportId(Long transportId) {
        this.transportId = transportId;
    }

    public BigDecimal getTransportErrAmount() {
        return transportErrAmount;
    }

    public void setTransportErrAmount(BigDecimal transportErrAmount) {
        this.transportErrAmount = transportErrAmount;
    }

    public BigDecimal getTransportOkAmount() {
        return transportOkAmount;
    }

    public void setTransportOkAmount(BigDecimal transportOkAmount) {
        this.transportOkAmount = transportOkAmount;
    }
}