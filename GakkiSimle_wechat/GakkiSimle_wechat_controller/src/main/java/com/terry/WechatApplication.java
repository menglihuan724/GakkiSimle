package com.terry;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Created by terrymeng
 */

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
public class WechatApplication {

    public static void main(String[] args) {
       SpringApplication.run(WechatApplication.class, args);
    }
}