package com.fsy.controlstrategy.service;

import com.fsy.controlstrategy.controller.param.OrderParam;
import com.fsy.controlstrategy.controller.vo.TransportOrderVo;
import com.fsy.controlstrategy.entity.ErrAmuntHistory;
import com.fsy.controlstrategy.entity.TransportOrder;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface TransportOrderService {

    /**
     * 按照条件分页获取运输订单数据
     * @param orderParam
     * @return
     */
    PageInfo<TransportOrderVo> getAllOrderInfo(OrderParam orderParam);

    /**
     * 导出数据
     * @param orderParam
     * @return
     */
    List<TransportOrderVo> getExportOrderInfo (OrderParam orderParam);

    void updateOrInsertTransportOrder (TransportOrder transportOrder);

    TransportOrder getTransportOrderById (Integer id);

    List<ErrAmuntHistory> getAllErrData();
}
