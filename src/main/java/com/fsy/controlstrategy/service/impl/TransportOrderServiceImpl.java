package com.fsy.controlstrategy.service.impl;

import com.fsy.controlstrategy.controller.param.OrderParam;
import com.fsy.controlstrategy.entity.TransportOrder;
import com.fsy.controlstrategy.entity.enums.ItemsTypeEnum;
import com.fsy.controlstrategy.mapper.TransportOrderMapper;
import com.fsy.controlstrategy.service.TransportOrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class TransportOrderServiceImpl implements TransportOrderService {
    @Autowired
    private TransportOrderMapper transportOrderMapper;
    @Override
    public List<TransportOrder> getAllTransportOrderInfo(OrderParam orderParam) {
        return transportOrderMapper.getAllTransportOrder(orderParam);
    }

    @Override
    public PageInfo<TransportOrder> getAllOrderInfo(OrderParam orderParam) {
        PageHelper.startPage(orderParam.getOffset(),orderParam.getLimit());
        List<TransportOrder> transportOrderList = transportOrderMapper.getAllTransportOrder(orderParam);
        PageInfo<TransportOrder> pageInfo = new PageInfo<>(transportOrderList);
        List<TransportOrder> list = pageInfo.getList();
        if (!CollectionUtils.isEmpty(list)) {
            for (TransportOrder vo : list) {
                String itemName = ItemsTypeEnum.getItemsNameByCode(vo.getItems());
                if (StringUtil.isEmpty(itemName)) {
                    continue;
                }
                vo.setItems(itemName);
            }
        }
        return pageInfo;
    }
}
