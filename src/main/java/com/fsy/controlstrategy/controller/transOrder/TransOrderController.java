package com.fsy.controlstrategy.controller.transOrder;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.fsy.controlstrategy.controller.base.BaseController;
import com.fsy.controlstrategy.controller.base.ResponseVo;
import com.fsy.controlstrategy.controller.param.OrderParam;
import com.fsy.controlstrategy.controller.vo.TransportOrderVo;
import com.fsy.controlstrategy.entity.ControlQuartz;
import com.fsy.controlstrategy.entity.ErrAmuntHistory;
import com.fsy.controlstrategy.entity.TransportOrder;
import com.fsy.controlstrategy.entity.enums.ControlWebStatusEnum;
import com.fsy.controlstrategy.mapper.ControlQuartzMapper;
import com.fsy.controlstrategy.quartz.CalculateOrderAmountQuartz;
import com.fsy.controlstrategy.service.TransportOrderService;
import com.fsy.controlstrategy.util.excel.ExcelUtil;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Objects;

@RestController
@Slf4j
public class TransOrderController extends BaseController {

    @Autowired
    private TransportOrderService transportOrderService;

    @Autowired
    private CalculateOrderAmountQuartz calculateOrderAmountQuartz;

    @Autowired
    private ControlQuartzMapper controlQuartzMapper;

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
    @ResponseBody
    @CrossOrigin
    public ResponseVo exportTransOrderExcel (HttpServletRequest request, HttpServletResponse response,
                                             @RequestBody OrderParam orderParam) throws Exception {
        OutputStream out = null;
        orderParam.setLimit(1000);
        orderParam.setOffset(0);
        String fileName = "我的导出魔板";
        // 以流的方式返回给前端，提前设置好相应流
        try {
            out = ExcelUtil.getOutputStreamFormat(fileName,response);
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
            // 写仅有一个 Sheet 的 Excel 文件, 此场景较为通用
            Sheet sheet1 = new Sheet(1, 0, TransportOrderVo.class);
            // 第一个 sheet 名称
            sheet1.setSheetName("运输订单信息");
            // 写数据到 Writer 上下文中
            // 入参1: 数据库查询的数据list集合
            // 入参2: 要写入的目标 sheet
            writer.write(transportOrderService.getExportOrderInfo(orderParam), sheet1);
            // 将上下文中的最终 outputStream 写入到指定文件中
            writer.finish();
        } catch (IOException e) {
            log.info("写入流异常");
        } finally {
            if (!Objects.isNull(out)) {
                out.close();
            }
        }
        return generateResponseVo(ControlWebStatusEnum.SUCCESS, null);
    }


    @RequestMapping("/updateOrInsertTransportOrder")
    @CrossOrigin
    public ResponseVo updateOrInsertTransportOrder (@RequestBody TransportOrder transportOrder) {
        transportOrderService.updateOrInsertTransportOrder(transportOrder);
        return generateResponseVo(ControlWebStatusEnum.SUCCESS, null);
    }

    @RequestMapping("/getTransPortOrderById")
    @CrossOrigin
    public ResponseVo getTransPortOrderById (Integer id) {
        TransportOrder transportOrder = transportOrderService.getTransportOrderById(id);
        return generateResponseVo(ControlWebStatusEnum.SUCCESS, transportOrder);
    }

    @RequestMapping("/getErrData")
    @CrossOrigin
    public ResponseVo getErrData () {
        List<ErrAmuntHistory> list = transportOrderService.getAllErrData();
        return generateResponseVo(ControlWebStatusEnum.SUCCESS, list);
    }

    @RequestMapping("/batchRunningData")
    @CrossOrigin
    public ResponseVo batchRunningData () {
        ControlQuartz param = new ControlQuartz();
        param.setQuartzTable("transport_order");
        param.setQuartzClass("CalculateOrderAmountQuartz");
        ControlQuartz quartz = controlQuartzMapper.selectControlQuartzByParam(param);
        calculateOrderAmountQuartz.process(quartz);
        return generateResponseVo(ControlWebStatusEnum.SUCCESS, null);
    }
}
