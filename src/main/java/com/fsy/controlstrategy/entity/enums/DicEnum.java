package com.fsy.controlstrategy.entity.enums;

public enum DicEnum {
    DIC_PLACT_TYPE("1","站点"),
    DiC_TYPE("2","品目");
    private String dicCode;
    private String dicValue;

    DicEnum(String dicCode, String dicValue) {
        this.dicCode = dicCode;
        this.dicValue = dicValue;
    }

    DicEnum() {
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

    public static String getDicValueByCode (String dicCode) {
        if (dicCode == null) {
            return null;
        }
        for (DicEnum dicEnum : DicEnum.values()) {
            String enumCode = dicEnum.getDicCode().toString();
            if (enumCode.equals(dicCode)) {
                return dicEnum.getDicValue();
            }
        }
        return null;
    }
}
