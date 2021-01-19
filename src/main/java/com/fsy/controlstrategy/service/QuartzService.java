package com.fsy.controlstrategy.service;

import com.fsy.controlstrategy.entity.ControlQuartz;

/**
 * @Auther:
 * @Date:
 * @Description:
 */
public interface QuartzService {

    /**
     * 计算所有的金额是否正确不正确更新
     *
     * @return
     */
    void calculateOrderAmount(ControlQuartz quartz);
}
