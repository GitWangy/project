package com.fsy.controlstrategy.mapper;

import com.fsy.controlstrategy.entity.ControlUser;

public interface ControlUserMapper {
    int insert(ControlUser record);

    int insertSelective(ControlUser record);

    /**
     * 查询用户的信息
     * @param param
     * @return
     */
    ControlUser selectUserByParam (ControlUser param);

    /**
     * 通过用户id查询用户信息
     * @param userId
     * @return
     */
    ControlUser selectUserById (Long userId);
}