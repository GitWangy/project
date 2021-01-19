package com.fsy.controlstrategy.mapper;

import com.fsy.controlstrategy.controller.param.ControDicParam;
import com.fsy.controlstrategy.entity.ControlDic;

import java.util.List;

public interface ControlDicMapper {
    int insert(ControlDic record);

    int insertSelective(ControlDic record);

    /**
     * 获取字典类型对应的所有字典值
     * @param dicType
     * @return
     */
    List<ControlDic> getAllControlDicByType (String dicType);

    void addControlDic (ControDicParam controDicParam);
}