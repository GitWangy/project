package com.fsy.controlstrategy.mapper;

import com.fsy.controlstrategy.entity.SysUser;

public interface SysUserMapper {
    int insert(SysUser record);

    int insertSelective(SysUser record);

    /**
     * 通过自增主键查询用户信息
     * @param id
     * @return
     */
    SysUser selectUserById (Long id);

    /**
     * 通过用户名获取用户信息
     * @param userName
     * @return
     */
    SysUser getUserByUserName (String userName);
}