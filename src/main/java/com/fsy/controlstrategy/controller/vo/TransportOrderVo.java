package com.fsy.controlstrategy.controller.vo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class TransportOrderVo implements Serializable {

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

}
