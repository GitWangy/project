package com.fsy.controlstrategy.controller.base;

import com.fsy.controlstrategy.entity.enums.AreaAnalysisWebStatusEnum;

public class BaseController {
    /**
     * 生成统一的返回响应对象
     *
     * @param webStatusEnum 状态码枚举
     * @param data          数据对象
     * @param <T>           数据对象类型参数
     * @return
     */
    public <T> ResponseVo generateResponseVo(AreaAnalysisWebStatusEnum webStatusEnum, T data) {
        return new ResponseVo<>(webStatusEnum.getCode(), webStatusEnum.getDesc(), data);
    }

    public <T> ResponseVo generateResponseVo(String code, String desc, T data) {
        return new ResponseVo<>(code, desc, data);
    }
}
