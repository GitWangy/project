package com.fsy.controlstrategy.controller.dic;

import com.fsy.controlstrategy.controller.base.BaseController;
import com.fsy.controlstrategy.controller.base.ResponseVo;
import com.fsy.controlstrategy.controller.param.ControDicParam;
import com.fsy.controlstrategy.entity.ControlDic;
import com.fsy.controlstrategy.entity.enums.ControlWebStatusEnum;
import com.fsy.controlstrategy.service.ControlDicService;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/dic")
public class ControlDicController extends BaseController {

    @Autowired
    private ControlDicService controlDicService;

    @RequestMapping("/getAllControDicByType")
    public ResponseVo getAllControDicByType (@RequestParam String dicType) {
        if (StringUtil.isEmpty(dicType)) {
            return generateResponseVo(ControlWebStatusEnum.PARAM_NOT_NULL, null);
        }
        List<ControlDic> list = controlDicService.getAllControlDicByType(dicType);
        return generateResponseVo(ControlWebStatusEnum.SUCCESS, list);
    }

    @RequestMapping("/addControDic")
    public ResponseVo addControDic (@RequestBody ControDicParam controDicParam) {
        if (StringUtils.isEmpty(controDicParam)) {
            return generateResponseVo(ControlWebStatusEnum.PARAM_NOT_NULL, null);
        }
        Date date = new Date();

        return null;
    }

}
