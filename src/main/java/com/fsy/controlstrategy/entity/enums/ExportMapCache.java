package com.fsy.controlstrategy.entity.enums;/**
 * @Auther:
 * @Date:
 * @Description:
 */

import com.fsy.controlstrategy.util.ExportExcelUtils;

import java.util.*;

/**
 * @author wangyv
 * @project controlstrategy
 * @className ExportMapCache
 * @description
 * @create 2020-12-17 14:31
 **/
public class ExportMapCache {

    public List<Map<String, String>> getListMap() {
        List<Map<String, String>> fieldList = new ArrayList<>();
        Map<String, String> field = new HashMap<>();
        field.put(ExportExcelUtils.FIELDNAME, "userName");
        field.put(ExportExcelUtils.FIELDZNAME, "姓名");
        fieldList.add(field);

        field = new HashMap<>();
        field.put(ExportExcelUtils.FIELDNAME, "password");
        field.put(ExportExcelUtils.FIELDZNAME, "密码");
        fieldList.add(field);

        field = new HashMap<>();
        field.put(ExportExcelUtils.FIELDNAME, "valid");
        field.put(ExportExcelUtils.FIELDZNAME, "是否有效");
        fieldList.add(field);
        return fieldList;
    }
}
