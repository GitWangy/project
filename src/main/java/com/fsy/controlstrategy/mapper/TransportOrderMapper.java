package com.fsy.controlstrategy.mapper;

import com.fsy.controlstrategy.controller.param.OrderParam;
import com.fsy.controlstrategy.controller.vo.TransportOrderVo;
import com.fsy.controlstrategy.entity.TransportOrder;

import java.util.List;

public interface TransportOrderMapper {
    int insert(TransportOrder record);

    int insertSelective(TransportOrder record);

    /**
     * 批量更新订单信息
     *
     * @param items
     */
    void updateTotalAmountOrderById (List<TransportOrderVo> items);

    /**
     * 获取符合条件的订单信息
     * @param orderParam
     * @return
     */
    List<TransportOrderVo> getAllTransportOrder (OrderParam orderParam);
}