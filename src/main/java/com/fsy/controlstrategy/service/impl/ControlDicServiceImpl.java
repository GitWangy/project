package com.fsy.controlstrategy.service.impl;

import cn.hutool.core.util.NumberUtil;
import com.fsy.controlstrategy.controller.param.ControDicParam;
import com.fsy.controlstrategy.controller.vo.ControlDicVo;
import com.fsy.controlstrategy.controller.vo.TransportOrderVo;
import com.fsy.controlstrategy.entity.ControlDic;
import com.fsy.controlstrategy.entity.enums.DicEnum;
import com.fsy.controlstrategy.entity.enums.ValidEnum;
import com.fsy.controlstrategy.mapper.ControlDicMapper;
import com.fsy.controlstrategy.service.ControlDicService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.NumberUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
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

    @Override
    public PageInfo<ControlDicVo> getControlDic(ControDicParam controDicParam) {
        PageHelper.startPage(controDicParam.getOffset(), controDicParam.getLimit());
        PageInfo<ControlDicVo> list = new PageInfo<ControlDicVo>(controlDicMapper.getControlDicByParam(controDicParam));
        List<ControlDicVo> controlDicList = list.getList();
        for (ControlDicVo controlDic : controlDicList) {
            ControlDicVo controlDicVo = new ControlDicVo();
            BeanUtils.copyProperties(controlDic,controlDicVo);
            controlDicVo.setDicType(DicEnum.getDicValueByCode(controlDic.getDicType()));
            controlDicVo.setValid(ValidEnum.getValidValueByCode(controlDic.getValid()));
        }
        return list;
    }

    @Override
    public void updateControlDic(ControDicParam controDicParam) {
        if (!StringUtils.isEmpty(controDicParam)) {
            if (StringUtils.isEmpty(controDicParam.getId())) {
                controlDicMapper.addControlDic(controDicParam);
            } else {
                ControlDic controlDic = controlDicMapper.getControlDicByid(controDicParam.getId());
                if (controlDic != null) {
                    controlDicMapper.updateControlDic(controDicParam);
                } else {
                    controlDicMapper.addControlDic(controDicParam);
                }
            }
        }
    }

    @Override
    public ControlDicVo getControlDicById(Long id) {
        if (id != null) {
            ControlDic controlDic = controlDicMapper.getControlDicByid(id);
            ControlDicVo controlDicVo = new ControlDicVo();
            BeanUtils.copyProperties(controlDic,controlDicVo);
            controlDicVo.setDicType(controlDic.getDicType().toString());
            controlDicVo.setValid(controlDic.getValid().toString());
            return controlDicVo;
        }
        return null;
    }
}
