package com.fsy.controlstrategy.service;

import com.fsy.controlstrategy.controller.param.OrderParam;
import com.fsy.controlstrategy.entity.TransportOrder;

import java.util.List;

public interface TransportOrderService {
    List<TransportOrder> getAllTransportOrderInfo (OrderParam orderParam);
}
