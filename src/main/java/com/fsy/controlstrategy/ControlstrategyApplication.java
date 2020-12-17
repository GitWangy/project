package com.fsy.controlstrategy;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.fsy.controlstrategy.mapper")
@SpringBootApplication
@Slf4j
public class ControlstrategyApplication {

    public static void main(String[] args) {

        SpringApplication.run(ControlstrategyApplication.class, args);
    }
    /*
    1.本次通过springboot 整合mybatis 发生的问题，在整合是mysql 链接数据库差了点东西
    mybatis的xml文件和mapper文件的包的名字不一样，导致除了问题。
    mybatis.type-aliases-package 配置这个的作用是，在接受返回值的时候，这个就可以直接将自定义的model扫描，然后使用，要不然就会找不到这个类
    需要注意namespace的名字是否是Mapper的包名字。id是mapper的方法名。
    mybatis.mapper-locations 的作用是将mapper 接口和mapper.xml放在同一个包下
    2.mybatis 查询数据时候，部分字段缺失，是因为没有加驼峰映射的配置导致的。
     */
}
