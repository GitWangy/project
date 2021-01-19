package com.fsy.controlstrategy.mapper;

import com.fsy.controlstrategy.controller.param.OrderParam;
import com.fsy.controlstrategy.entity.TransportOrder;

import java.util.List;

public interface TransportOrderMapper {
    int insert(TransportOrder record);

    int insertSelective(TransportOrder record);

    /**
     * 获取符合条件的订单信息
     * @param orderParam
     * @return
     */
    List<TransportOrder> getAllTransportOrder (OrderParam orderParam);

    /**
     * 批量更新订单信息
     *
     * @param items
     */
    void updateTotalAmountOrderById (List<TransportOrder> items);
}