package com.fsy.controlstrategy.service.impl;

import com.fsy.controlstrategy.entity.SysUser;
import com.fsy.controlstrategy.mapper.SysUserMapper;
import com.fsy.controlstrategy.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private SysUserMapper sysUserMapper;
    /**
     * 查询用户信息
     * @param id
     * @return
     */
    @Override
    public SysUser getUserById(Long id) {
        return sysUserMapper.selectUserById(id);
    }

    @Override
    public SysUser getUserByUserName(String userName) {
        return sysUserMapper.getUserByUserName(userName);
    }
}
