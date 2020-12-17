package com.fsy.controlstrategy.service;

import com.fsy.controlstrategy.entity.SysUser;

public interface LoginService {

    SysUser getUserById (Long id);

    SysUser getUserByUserName (String userName);
}
