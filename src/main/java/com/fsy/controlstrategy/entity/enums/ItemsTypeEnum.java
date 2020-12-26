package com.fsy.controlstrategy.entity.enums;

import org.apache.commons.lang.StringUtils;

/**
 * 品目类型枚举
 */
public enum ItemsTypeEnum {
    ITEMS_TYPE_ENUM__00("细石","0"),
    ITEMS_TYPE_ENUM__01("尾矿粗砂","1"),
    ITEMS_TYPE_ENUM__02("尾矿细砂","2"),
    ITEMS_TYPE_ENUM__03("矿石","3"),
    ITEMS_TYPE_ENUM__04("尾矿粗中砂","4"),
    ITEMS_TYPE_ENUM__05("尾矿粗粗砂","5"),
    ITEMS_TYPE_ENUM__06("二矿","6"),
    ;

    private String itemsName;
    private String itemsCode;

    ItemsTypeEnum(String itemsName, String itemsCode) {
        this.itemsName = itemsName;
        this.itemsCode = itemsCode;
    }

    ItemsTypeEnum() {
    }

    public String getItemsName() {
        return itemsName;
    }

    public void setItemsName(String itemsName) {
        this.itemsName = itemsName;
    }

    public String getItemsCode() {
        return itemsCode;
    }

    public void setItemsCode(String itemsCode) {
        this.itemsCode = itemsCode;
    }

    /**
     * 根据品名code 获取对应的名称
     * @param itemsCode
     * @return
     */
    public static String getItemsNameByCode (String itemsCode) {
        if (StringUtils.isEmpty(itemsCode)) {
            return null;
        }
        for (ItemsTypeEnum itemsTypeEnum : ItemsTypeEnum.values()) {
             String code = itemsTypeEnum.getItemsCode();
             if (code.equals(itemsCode)) {
                 return itemsTypeEnum.getItemsName();
             }
        }
        return null;
    }
}
