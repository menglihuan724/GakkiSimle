package com.terry.gakkisimle.im;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;


/**
 * Created by terrymeng
 * IM启动类
 */

@EnableEurekaClient
@SpringBootApplication(scanBasePackages = "com.terry.gakkisimle.im")
@EntityScan(basePackages={"com.terry.gakkisimle.wechat.entity.po","com.terry.gakkisimle.im.entity.po"})
@EnableFeignClients
//@EnableJpaRepositories(basePackages = "com.terry.gakkisimle.im.dao")
@MapperScan("com.terry.gakkisimle.im.mapper" )
public class IMApplication {
    public static void main(String[] args) {
        SpringApplication.run(IMApplication.class, args);
    }
}