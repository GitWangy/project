package com.fsy.controlstrategy.service;

import com.fsy.controlstrategy.controller.param.OrderParam;
import com.fsy.controlstrategy.entity.TransportOrder;
import com.github.pagehelper.PageInfo;
import redis.clients.jedis.Response;

import java.util.List;

public interface TransportOrderService {
    List<TransportOrder> getAllTransportOrderInfo (OrderParam orderParam);

    /**
     * 按照条件分页获取运输订单数据
     * @param orderParam
     * @return
     */
    PageInfo<TransportOrder> getAllOrderInfo(OrderParam orderParam);
}
