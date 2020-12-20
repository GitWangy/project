package com.fsy.controlstrategy.controller.transOrder;

import com.fsy.controlstrategy.controller.base.BaseController;
import com.fsy.controlstrategy.controller.base.ResponseVo;
import com.fsy.controlstrategy.controller.param.OrderParam;
import com.fsy.controlstrategy.entity.SysUser;
import com.fsy.controlstrategy.entity.TransportOrder;
import com.fsy.controlstrategy.entity.enums.ControlWebStatusEnum;
import com.fsy.controlstrategy.service.TransportOrderService;
import com.fsy.controlstrategy.util.ExportExcelUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class TransOrderController extends BaseController {

@Autowired
private TransportOrderService transportOrderService;

@RequestMapping("/getAllOrderBasicInfo")
public ResponseVo getAllOrderBasicInfo (@RequestBody OrderParam orderParam) {
    List<TransportOrder> list = transportOrderService.getAllTransportOrderInfo(orderParam);
    return generateResponseVo(ControlWebStatusEnum.SUCCESS, list);
}
}
