package com.terry.gakkisimle.IM;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;


/**
 * Created by terrymeng
 * IM启动类
 */

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
@MapperScan(basePackages = {"com.terry.gakkisimle.IM.mapper"})
@ComponentScan(basePackages = {"com.terry.gakkisimle.IM"})
public class IMApplication {
    public static void main(String[] args) {
        SpringApplication.run(IMApplication.class, args);
    }
}