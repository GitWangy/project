package com.fsy.controlstrategy.mapper;

import com.fsy.controlstrategy.entity.ControlQuartz;

import java.util.Date;

public interface ControlQuartzMapper {
    int insert(ControlQuartz record);

    int insertSelective(ControlQuartz record);

    /**
     * 获取对应的定时任务记录
     *
     * @param controlQuartz
     * @return
     */
    ControlQuartz selectControlQuartzByParam(ControlQuartz controlQuartz);

    /**
     * 更新lastUt通过id
     * @param id
     */
    void updateLastUtById (Long id, String lastUt);
}