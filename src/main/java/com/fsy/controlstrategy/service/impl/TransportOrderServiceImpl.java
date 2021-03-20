package com.fsy.controlstrategy.service.impl;

import com.fsy.controlstrategy.controller.param.OrderParam;
import com.fsy.controlstrategy.entity.ControlDic;
import com.fsy.controlstrategy.controller.vo.TransportOrderVo;
import com.fsy.controlstrategy.entity.ErrAmuntHistory;
import com.fsy.controlstrategy.entity.TransportOrder;
import com.fsy.controlstrategy.mapper.ControlDicMapper;
import com.fsy.controlstrategy.mapper.ErrAmuntHistoryMapper;
import com.fsy.controlstrategy.mapper.TransportOrderMapper;
import com.fsy.controlstrategy.service.TransportOrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TransportOrderServiceImpl implements TransportOrderService {
    @Autowired
    private TransportOrderMapper transportOrderMapper;

    @Autowired
    private ControlDicMapper controlDicMapper;

    @Autowired
    private ErrAmuntHistoryMapper errAmuntHistoryMapper;


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
        BigDecimal totalAmount = BigDecimal.ZERO;
        if (!CollectionUtils.isEmpty(list)) {
            for (TransportOrderVo vo : list) {
                String typeCode = vo.getItems();
                String stationCode = vo.getSupplierStation();
                vo.setItems(map.get(typeCode));
                vo.setSupplierStation(map.get(stationCode));
                if (!StringUtils.isEmpty(vo.getTotalAmountOrder())) {
                    totalAmount = totalAmount.add(vo.getTotalAmountOrder());
                }
            }
            list.get(0).setTotalAmount(totalAmount);
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

    @Override
    public void updateOrInsertTransportOrder(TransportOrder transportOrder) {
        if (transportOrder == null) {
            return;
        }
        transportOrder.setUpdateTime(new Date());
        Integer id = transportOrder.getId();
        if (id == null) {
            transportOrder.setCreateTime(new Date());
            transportOrder.setValid(1);
            transportOrderMapper.insertSelective(transportOrder);
        } else {
            TransportOrder transportOrderResult = transportOrderMapper.getTransPortOrderById(id);
            if (transportOrderResult == null) {
                transportOrder.setCreateTime(new Date());
                transportOrder.setValid(1);
                transportOrderMapper.insertSelective(transportOrder);
            } else {
                transportOrderMapper.updateTransPortOrder(transportOrder);
            }
        }
    }

    @Override
    public TransportOrder getTransportOrderById(Integer id) {
        TransportOrder transportOrder = transportOrderMapper.getTransPortOrderById(id);
        return transportOrder;
    }

    @Override
    public List<ErrAmuntHistory> getAllErrData() {
        List<ErrAmuntHistory> list = errAmuntHistoryMapper.getAllErrData();
        return list;
    }
}
