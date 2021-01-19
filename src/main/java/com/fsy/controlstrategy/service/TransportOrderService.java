package com.fsy.controlstrategy.service;

import com.fsy.controlstrategy.controller.param.OrderParam;
import com.fsy.controlstrategy.controller.vo.TransportOrderVo;
import com.github.pagehelper.PageInfo;


public interface TransportOrderService {

    /**
     * 按照条件分页获取运输订单数据
     * @param orderParam
     * @return
     */
    PageInfo<TransportOrderVo> getAllOrderInfo(OrderParam orderParam);
}
