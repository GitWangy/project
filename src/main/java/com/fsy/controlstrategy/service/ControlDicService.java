package com.fsy.controlstrategy.service;

import com.fsy.controlstrategy.controller.param.ControDicParam;
import com.fsy.controlstrategy.controller.vo.ControlDicVo;
import com.fsy.controlstrategy.entity.ControlDic;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ControlDicService {
    /**
     * 根据字典类型获取所有的字典
     * @param dicType
     * @return
     */
    public List<ControlDic> getAllControlDicByType (String dicType);

    public void addControlDic (ControDicParam controDicParam);

    /**
     * 获取数据字典的信息
     * @param controDicParam
     * @return
     */
    public PageInfo<ControlDicVo> getControlDic (ControDicParam controDicParam);

    /**
     * 修改数据字典
     */
    public void updateControlDic (ControDicParam controDicParam);

    public ControlDicVo getControlDicById (Long id);
}
