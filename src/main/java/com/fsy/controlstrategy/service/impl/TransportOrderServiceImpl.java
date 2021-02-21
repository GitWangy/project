package com.fsy.controlstrategy.service.impl;

import com.fsy.controlstrategy.controller.param.OrderParam;
import com.fsy.controlstrategy.entity.ControlDic;
import com.fsy.controlstrategy.controller.vo.TransportOrderVo;
import com.fsy.controlstrategy.entity.TransportOrder;
import com.fsy.controlstrategy.mapper.ControlDicMapper;
import com.fsy.controlstrategy.mapper.TransportOrderMapper;
import com.fsy.controlstrategy.service.TransportOrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TransportOrderServiceImpl implements TransportOrderService {
    @Autowired
    private TransportOrderMapper transportOrderMapper;

    @Autowired
    private ControlDicMapper controlDicMapper;


    @Override
    public PageInfo<TransportOrderVo> getAllOrderInfo(OrderParam orderParam) {
        PageHelper.startPage(orderParam.getOffset(), orderParam.getLimit());
        List<TransportOrderVo> transportOrderList = transportOrderMapper.getAllTransportOrder(orderParam);
        List<ControlDic> dicList = controlDicMapper.getAllControlDicByType(null);
        Map<String, String> map = new HashMap<>();
        if (!CollectionUtils.isEmpty(dicList)) {
            for (ControlDic controlDic : dicList) {
                String code = controlDic.getDicCode();
                String value = controlDic.getDicName();
                map.put(code, value);
            }
        }
        PageInfo<TransportOrderVo> pageInfo = new PageInfo<>(transportOrderList);
        List<TransportOrderVo> list = pageInfo.getList();
        if (!CollectionUtils.isEmpty(list)) {
            for (TransportOrderVo vo : list) {
                String typeCode = vo.getItems();
                String stationCode = vo.getSupplierStation();
                vo.setItems(map.get(typeCode));
                vo.setSupplierStation(map.get(stationCode));
            }
        }
        return pageInfo;
    }

    @Override
    public List<TransportOrderVo> getExportOrderInfo(OrderParam orderParam) {
        List<TransportOrderVo> transportOrderList = transportOrderMapper.getAllTransportOrder(orderParam);
        List<ControlDic> dicList = controlDicMapper.getAllControlDicByType(null);
        Map<String, String> map = new HashMap<>();
        if (!CollectionUtils.isEmpty(dicList)) {
            for (ControlDic controlDic : dicList) {
                String code = controlDic.getDicCode();
                String value = controlDic.getDicName();
                map.put(code, value);
            }
        }
        if (!CollectionUtils.isEmpty(transportOrderList)) {
            for (TransportOrderVo vo : transportOrderList) {
                String typeCode = vo.getItems();
                String stationCode = vo.getSupplierStation();
                vo.setItems(map.get(typeCode));
                vo.setSupplierStation(map.get(stationCode));
            }
        }
        return transportOrderList;
    }
}
