package com.fsy.controlstrategy.service.impl;

import com.fsy.controlstrategy.controller.param.OrderParam;
import com.fsy.controlstrategy.entity.ControlQuartz;
import com.fsy.controlstrategy.entity.TransportOrder;
import com.fsy.controlstrategy.mapper.ControlQuartzMapper;
import com.fsy.controlstrategy.mapper.TransportOrderMapper;
import com.fsy.controlstrategy.service.QuartzService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wangyv
 * @project controlstrategy
 * @className QuartzServiceImpl
 * @description
 * @create 2021-01-19 10:37
 **/
@Slf4j
@Service
public class QuartzServiceImpl implements QuartzService {

    private static final String format = "yyyy-MM-dd HH:mm:ss";

    @Autowired
    private TransportOrderMapper transportOrderMapper;

    @Autowired
    private ControlQuartzMapper controlQuartzMapper;

    @Override
    public void calculateOrderAmount(ControlQuartz quartz) {
        Integer limit = 1000;
        Long lastId = 0L;
        String formatDate = DateFormatUtils.format(new Date(),format);
        Long quartzId = quartz.getId();

        OrderParam orderParam = new OrderParam();
        orderParam.setLimit(limit);
        orderParam.setCurrentDate(formatDate);
        orderParam.setLastId(lastId);
        orderParam.setLastUt(DateFormatUtils.format(quartz.getLastUpdateTime(),format));
        // AND update_time>=lastUt  AND update_time < now() AND abs_pf_project_id > id ORDER BY abs_pf_project_id asc LIMIT ?
        // 可以有效的防止漏数据的情况
        boolean hasMore = true;
        while (hasMore) {
            List<TransportOrder> transportOrders = transportOrderMapper.getAllTransportOrder(orderParam);
            if (!CollectionUtils.isEmpty(transportOrders)) {
                List<TransportOrder> errTransportOrder = calculateOrderAmount(transportOrders);
                if (!CollectionUtils.isEmpty(errTransportOrder)) {
                    transportOrderMapper.updateTotalAmountOrderById(errTransportOrder);
                    log.info("已更新错误计算，他们的id分别为:{}",errTransportOrder.stream().map(TransportOrder::getId).collect(Collectors.toList()));
                }
            }
            hasMore = transportOrders.size() == limit;
            orderParam.setLastId(Long.valueOf(transportOrders.size()-1));
        }

        controlQuartzMapper.updateLastUtById(quartzId,formatDate);
        log.info("已经完成lastUt的更新");
    }

    /**
     * 将错误的数据改正并返回
     *
     * @param list
     * @return
     */
    private List<TransportOrder> calculateOrderAmount(List<TransportOrder> list) {
        List<TransportOrder> resultList = new ArrayList<>();
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        list.stream().forEach(vo -> {
            //库里存储的值
            BigDecimal storeTotal = vo.getTotalAmountOrder();
            BigDecimal suttle = vo.getSuttle();
            BigDecimal unitPrice = vo.getUnitPrice();
            if (StringUtils.isEmpty(suttle) || StringUtils.isEmpty(unitPrice) || StringUtils.isEmpty(storeTotal)) {
                log.error("本条数据不正确，请录入人员重新填写，录入id 为{}" + vo.getId());
            }
            BigDecimal resultTotal = suttle.multiply(unitPrice);
            if (storeTotal.compareTo(resultTotal) != 0) {
                vo.setTotalAmountOrder(resultTotal);
                resultList.add(vo);
            }
        });
        return resultList;
    }
}
