package com.terry.gakkisimle;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by terrymeng
 * 微信小程序后台的启动类
 */

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
@ComponentScan(basePackages = {"com.terry.gakkisimle.wechat"})
public class WechatApplication {

    public static void main(String[] args) {
       SpringApplication.run(WechatApplication.class, args);
    }
}