package com.fsy.controlstrategy.service;

import com.fsy.controlstrategy.controller.param.ControDicParam;
import com.fsy.controlstrategy.entity.ControlDic;

import java.util.List;

public interface ControlDicService {
    /**
     * 根据字典类型获取所有的字典
     * @param dicType
     * @return
     */
    public List<ControlDic> getAllControlDicByType (String dicType);

    public void addControlDic (ControDicParam controDicParam);
}
