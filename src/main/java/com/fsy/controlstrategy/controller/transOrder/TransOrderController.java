package com.fsy.controlstrategy.controller.transOrder;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.fsy.controlstrategy.controller.base.BaseController;
import com.fsy.controlstrategy.controller.base.ResponseVo;
import com.fsy.controlstrategy.controller.param.OrderParam;
import com.fsy.controlstrategy.controller.vo.TransportOrderVo;
import com.fsy.controlstrategy.entity.enums.ControlWebStatusEnum;
import com.fsy.controlstrategy.service.TransportOrderService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@RestController
@Slf4j
public class TransOrderController extends BaseController {

    @Autowired
    private TransportOrderService transportOrderService;


    /**
     * 这个也可以自己定义分页方法，使用插件,会返回一些
     * 无用的值，看起来比较乱
     * @return
     */
    @RequestMapping("/getAllOrderBasicInfo")
    @CrossOrigin
    public ResponseVo getAllOrderBasicInfo (@RequestBody OrderParam orderParam) {
        PageInfo<TransportOrderVo> list = transportOrderService.getAllOrderInfo(orderParam);
        return generateResponseVo(ControlWebStatusEnum.SUCCESS, list);
    }

    @RequestMapping("/exportOrderInfo")
    public ResponseVo exportTransOrderExcel (HttpServletRequest request, HttpServletResponse response) {
        OutputStream out = null;
        OrderParam orderParam = new OrderParam();
        orderParam.setLimit(1000);
        orderParam.setOffset(0);
        try {
            out = new FileOutputStream("C:\\Users\\smfx1314\\Desktop\\bbb\\test.xlsx");
            ExcelWriter writer = EasyExcelFactory.getWriter(out);

            // 写仅有一个 Sheet 的 Excel 文件, 此场景较为通用
            Sheet sheet1 = new Sheet(1, 0, TransportOrderVo.class);

            // 第一个 sheet 名称
            sheet1.setSheetName("运输订单信息");

            // 写数据到 Writer 上下文中
            // 入参1: 数据库查询的数据list集合
            // 入参2: 要写入的目标 sheet
            writer.write((List<? extends BaseRowModel>) transportOrderService.getAllOrderInfo(orderParam), sheet1);

            // 将上下文中的最终 outputStream 写入到指定文件中
            writer.finish();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                // 关闭流
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return generateResponseVo(ControlWebStatusEnum.SUCCESS, null);
    }
}
