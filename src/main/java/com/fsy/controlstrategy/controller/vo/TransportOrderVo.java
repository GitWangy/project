package com.fsy.controlstrategy.controller.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
public class TransportOrderVo extends BaseRowModel implements Serializable   {

    private Integer id;

    @ExcelProperty(value = "供货人",index = 0)
    private String supperlier;

    @ExcelProperty(value = "车牌号",index = 1)
    private String licenseNumber;

    @ExcelProperty(value = "订单编号",index = 2)
    private Integer orderNumber;

    @ExcelProperty(value = "品目",index = 3)
    private String items;

    @ExcelProperty(value = "规模",index = 4)
    private String specification;

    @ExcelProperty(value = "毛重",index = 5)
    private BigDecimal roughWeight;

    @ExcelProperty(value = "净重",index = 6)
    private BigDecimal suttle;

    @ExcelProperty(value = "单价",index = 7)
    private BigDecimal unitPrice;

    @ExcelProperty(value = "本次订单总计金额",index = 8)
    private BigDecimal totalAmountOrder;

    @ExcelProperty(value = "报表期次",index = 9)
    private String reportYear;

    @ExcelProperty(value = "站点",index = 10)
    private String supplierStation;

    @ExcelProperty(value = "订单日期",index = 11)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderDate;

    private BigDecimal totalAmount;
}
