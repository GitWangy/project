package com.fsy.controlstrategy.service.impl;

import com.fsy.controlstrategy.controller.param.ControDicParam;
import com.fsy.controlstrategy.entity.ControlDic;
import com.fsy.controlstrategy.mapper.ControlDicMapper;
import com.fsy.controlstrategy.service.ControlDicService;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class ControlDicServiceImpl implements ControlDicService {

    @Autowired
    private ControlDicMapper controlDicMapper;

    /**
     * 获取字典类型对应的所有字典值
     * @param dicType
     * @return
     */
    @Override
    public List<ControlDic> getAllControlDicByType(String dicType) {
        if (StringUtil.isEmpty(dicType)) {
            return null;
        }
        return controlDicMapper.getAllControlDicByType(dicType);
    }

    /**
     * 添加字典值
     * @param controDicParam
     */
    @Override
    public void addControlDic(ControDicParam controDicParam) {
        if (StringUtils.isEmpty(controDicParam)) {
            return;
        }
        Date  date = new Date();
        controDicParam.setCreateTime(date);
        controDicParam.setUpdateTime(date);
        controDicParam.setValid(1);
        controlDicMapper.addControlDic(controDicParam);
    }
}
