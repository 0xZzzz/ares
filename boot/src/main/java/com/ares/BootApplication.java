package com.ares;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

/**
 * 启动类
 *
 * @author 0xZzzz
 */
@SpringBootApplication
@PropertySource(value = {"application.properties"})
@ImportResource(locations = {"classpath*:spring/spring-*.xml"})
@MapperScan(basePackages = "com.ares.dao")
public class BootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }
}


