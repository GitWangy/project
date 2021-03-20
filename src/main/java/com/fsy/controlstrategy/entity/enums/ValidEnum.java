package com.fsy.controlstrategy.entity.enums;

public enum ValidEnum {
    DiC_NO_VALUE("0","无效"),
    DiC_VALUE("1","有效");
    private String dicCode;
    private String dicValue;

    ValidEnum(String dicCode, String dicValue) {
        this.dicCode = dicCode;
        this.dicValue = dicValue;
    }
    ValidEnum() {
    }

    public String getDicCode() {
        return dicCode;
    }

    public void setDicCode(String dicCode) {
        this.dicCode = dicCode;
    }

    public String getDicValue() {
        return dicValue;
    }

    public void setDicValue(String dicValue) {
        this.dicValue = dicValue;
    }

    public static String getValidValueByCode (String dicCode) {
        if (dicCode == null) {
            return null;
        }
        for (ValidEnum validEnum : ValidEnum.values()) {
            String enumCode = validEnum.getDicCode();
            if (enumCode.equals(dicCode)) {
                return validEnum.getDicValue();
            }
        }
        return null;
    }
}
