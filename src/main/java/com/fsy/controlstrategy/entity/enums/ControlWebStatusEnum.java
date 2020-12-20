package com.fsy.controlstrategy.entity.enums;

public enum ControlWebStatusEnum {
    SUCCESS("5000", "成功"),
    FAILED("7000", "失败"),
    PARAM_ERROR("7001", "参数错误"),
    PARAM_NOT_NULL("7002", "参数不能为空"),
    FILE_DOWNLOAD_FAILURE("7003","文件下载失败"),
    PARAM_FORMAT_ERROR("7010", "参数格式错误"),

    //4000-4999 搜索页面使用
    KEYWORD_SHORT("4000","搜索关键字少于2个字符或大于200字符"),

    //自定义异常，用于前端弹窗
    CUSTOM_EXCEPTION("9000", "参数格式错误"),

    USER_NO_LOGIN("1000","当前用户名不存在"),
    SHIRO_ERROR("10001","shiro错误请联系管理员")
    ;

    private String code;
    private String desc;

    ControlWebStatusEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}

