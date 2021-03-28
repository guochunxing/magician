package com.workabee.cloud.magician.console;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * author: chunxing
 * date: 2021/1/13 10:41
 * description:
 */

@EnableDubbo
@SpringBootApplication
public class ConsoleApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsoleApplication.class, args);
    }
}
