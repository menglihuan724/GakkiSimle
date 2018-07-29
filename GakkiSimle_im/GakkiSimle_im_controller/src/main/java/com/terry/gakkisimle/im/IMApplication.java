package com.terry.gakkisimle.im;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;


/**
 * Created by terrymeng
 * IM启动类
 */

@EnableEurekaClient
@SpringBootApplication(scanBasePackages = "com.terry.gakkisimle.im")
@EnableFeignClients
@MapperScan("com.terry.gakkisimle.im.mapper" )
public class IMApplication {
    public static void main(String[] args) {
        SpringApplication.run(IMApplication.class, args);
    }
}