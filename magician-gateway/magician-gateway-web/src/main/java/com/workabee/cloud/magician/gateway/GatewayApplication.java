package com.workabee.cloud.magician.gateway;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * author: chunxing
 * date: 2021/1/13 10:41
 * description:
 */
@EnableDubbo
@SpringBootApplication(scanBasePackages = {"com.workabee.cloud.magician.gateway"})
@MapperScan({"com.workabee.cloud.magician.gateway.infra.dao"})//原生 mybatis 支持
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
