package com.fsy.controlstrategy.controller.transOrder;

import com.fsy.controlstrategy.controller.base.BaseController;
import com.fsy.controlstrategy.controller.base.ResponseVo;
import com.fsy.controlstrategy.controller.param.OrderParam;
import com.fsy.controlstrategy.controller.vo.TransportOrderVo;
import com.fsy.controlstrategy.entity.TransportOrder;
import com.fsy.controlstrategy.entity.enums.ControlWebStatusEnum;
import com.fsy.controlstrategy.service.TransportOrderService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    public ResponseVo getAllSupplierStation () {
        return null;
    }
}
