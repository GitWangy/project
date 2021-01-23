package com.fsy.controlstrategy.util;/**
 * @Auther:
 * @Date:
 * @Description:
 */

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @project controlstrategy
 * @className ExcelWriterFactory
 * @description
 * @author wangyv
 * @create 2021-01-20 10:27
 **/
public class ExcelWriterFactory extends ExcelWriter {
    private OutputStream outputStream;
    private int sheetNo = 1;

    public ExcelWriterFactory(OutputStream outputStream, ExcelTypeEnum typeEnum) {
        super(outputStream, typeEnum);
        this.outputStream = outputStream;
    }

    public ExcelWriterFactory write(List<? extends BaseRowModel> list, String sheetName, BaseRowModel object) {
        this.sheetNo++;
        try {
            Sheet sheet = new Sheet(sheetNo, 0, object.getClass());
            sheet.setSheetName(sheetName);
            this.write(list, sheet);
        }
        catch(Exception ex) {
            ex.printStackTrace();
            try {
                outputStream.flush();
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    @Override
    public void finish() {
        super.finish();
        try {
            outputStream.flush();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}