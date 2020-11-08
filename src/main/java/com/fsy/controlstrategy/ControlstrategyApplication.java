package com.fsy.controlstrategy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.fsy.controlstrategy.mapper")
@SpringBootApplication
public class ControlstrategyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControlstrategyApplication.class, args);
    }

}
