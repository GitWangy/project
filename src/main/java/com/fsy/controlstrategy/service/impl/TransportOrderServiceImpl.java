package com.fsy.controlstrategy.service.impl;

import com.fsy.controlstrategy.controller.param.OrderParam;
import com.fsy.controlstrategy.entity.TransportOrder;
import com.fsy.controlstrategy.mapper.TransportOrderMapper;
import com.fsy.controlstrategy.service.TransportOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportOrderServiceImpl implements TransportOrderService {
    @Autowired
    private TransportOrderMapper transportOrderMapper;
    @Override
    public List<TransportOrder> getAllTransportOrderInfo(OrderParam orderParam) {
        return transportOrderMapper.getAllTransportOrder(orderParam);
    }
}
