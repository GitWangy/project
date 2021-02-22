package com.fsy.controlstrategy.entity.enums;

public enum DicEnum {
    DIC_PLACT_TYPE(1,"站点"),
    DiC_TYPE(2,"品目");
    private Integer dicCode;
    private String dicValue;

    DicEnum(Integer dicCode, String dicValue) {
        this.dicCode = dicCode;
        this.dicValue = dicValue;
    }

    DicEnum() {
    }

    public Integer getDicCode() {
        return dicCode;
    }

    public void setDicCode(Integer dicCode) {
        this.dicCode = dicCode;
    }

    public String getDicValue() {
        return dicValue;
    }

    public void setDicValue(String dicValue) {
        this.dicValue = dicValue;
    }

    public static String getDicValueByCode (Integer dicCode) {
        if (dicCode == null) {
            return null;
        }
        for (DicEnum dicEnum : DicEnum.values()) {
            Integer enumCode = dicEnum.getDicCode();
            if (enumCode.equals(dicCode)) {
                return dicEnum.getDicValue();
            }
        }
        return null;
    }
}
