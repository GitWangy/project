package com.fsy.controlstrategy.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.lang.reflect.Field;
import java.security.KeyStore;
import java.util.List;
import java.util.Map;;
import org.apache.poi.ss.usermodel.*;



/**
 * @project controlstrategy
 * @className ExportExcelUtils
 * @description
 * @author wangyv
 * @create 2020-12-17 14:28
 **/
@Slf4j
public class ExportExcelUtils {

 //列名
 public static final String FIELDNAME = "fieldName";
 //列中文名
 public static final String FIELDZNAME = "fieldZName";

 public static void exportToExcel() {

 }

 /**
 * 生成workbook，并进行数据处理
 * @param list 数据
 * @param fieldList 列数据
 * @return
 */
public static <T> Workbook dealWorkbook(List<T> list , Map<String , String> fieldList) {
    //创建一个excel2003的WorkBook,对应一个Excel文件
    Workbook workbook = new HSSFWorkbook();
    try {
        //在Workbook中，创建一个sheet,名为test，对应Excel中的工作薄（sheet）
        Sheet sheet = workbook.createSheet("test");
        dealSheetData(sheet , list , fieldList);
    } catch (Exception e) {
        log.info("导出Excel失败！");
        log.error(e.getMessage());
    }
    return workbook;
}

    /**
     * 处理sheet的数据内容
     * @param sheet sheet内容
     * @param list 数据
     * @param fieldList 列名
     */
    private static <T> void dealSheetData(Sheet sheet, List<T> list, Map<String, String> map) {
        //在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        Row row = sheet.createRow( 0);
        // 填充表头
        for (Map.Entry<String, String> entry : map.entrySet()) {
            int i = 0;
            Cell cell = row.createCell(i);
            String name = entry.getKey();
            String value = entry.getValue();
            value = value == null ? "" :value.toString();
            cell.setCellValue(name);
            sheet.autoSizeColumn(i);
            i++;
        }
        // 填充内容
        for (int index = 0; index < list.size(); index++) {
            row = sheet.createRow(index + 1);
            T item = list.get(index);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                int i = 0;
                String value = entry.getValue();
                value = value == null ? "" :value.toString();
                row.createCell(i).setCellValue(value);
            }
        }
    }

    /**
     * 得到属性的值
     * @param fieldName
     * @param item
     * @return
     */
    private static <T> Object getItemFieldValue(String fieldName, T item) {
        try {
            Field field = item.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            //属性的值
            return  field.get(item);
        } catch (Exception e) {
            log.error("field {} is error" , fieldName , e);
            return null;
        }

    }

}
