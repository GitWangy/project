package com.fsy.controlstrategy.service.impl;

import com.fsy.controlstrategy.entity.ControlUser;
import com.fsy.controlstrategy.mapper.ControlUserMapper;
import com.fsy.controlstrategy.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private ControlUserMapper controlUserMapper;

    /**
     * 查询用户信息
     * @param param
     * @return
     */
    @Override
    public ControlUser getUserByUserInfo(ControlUser param) {
        return controlUserMapper.selectUserByParam(param);
    }
}
