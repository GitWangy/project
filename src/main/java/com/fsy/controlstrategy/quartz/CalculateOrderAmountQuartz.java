package com.fsy.controlstrategy.quartz;

import com.fsy.controlstrategy.entity.ControlQuartz;
import com.fsy.controlstrategy.mapper.ControlQuartzMapper;
import com.fsy.controlstrategy.service.QuartzService;
import com.github.pagehelper.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.util.StringUtils;

/**
 * @author wangyv
 * @project controlstrategy
 * @className ControlQuartz
 * @description  校验订单金额是否正确，不正确及时改正
 * @create 2021-01-15 16:39
 **/
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
@Slf4j
public class CalculateOrderAmountQuartz implements SchedulingConfigurer {

    @Autowired
    private ControlQuartzMapper controlQuartzMapper;

    @Autowired
    private QuartzService quartzService;

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {

        ControlQuartz param = new ControlQuartz();
        param.setQuartzTable("transport_order");
        param.setQuartzClass("CalculateOrderAmountQuartz");
        String cronExpress = null;
        ControlQuartz quartz = controlQuartzMapper.selectControlQuartzByParam(param);
        if (StringUtils.isEmpty(quartz) || StringUtil.isEmpty(quartz.getQuartzTime())) {
            cronExpress = "0 */1 * * * ?";
            log.error("获取定时任务时间失败,使用默认的时间");
        } else {
            cronExpress = quartz.getQuartzTime();
        }

        String finalCronExpress = cronExpress;
        scheduledTaskRegistrar.addTriggerTask(() -> process(quartz),
                triggerContext -> {
                    return new CronTrigger(finalCronExpress).nextExecutionTime(triggerContext);
                });
    }

    /**
     * 定时任务计算逻辑
     * @param quartz
     */
    public void process(ControlQuartz quartz) {
        log.info("------------计算每笔订单的金额：开始---------------");
        long startTime = System.currentTimeMillis();
        quartzService.calculateOrderAmount(quartz);
        long endTime = System.currentTimeMillis();
        log.info("------------计算每笔订单的金额：结束,耗时{}---------------",(endTime-startTime));
    }
}
