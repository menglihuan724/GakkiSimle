package com.terry.gakkisimle;


import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
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
    @Bean
    public IRule ribbonRule() {
        return new BestAvailableRule();//这里配置策略，和配置文件对应
    }

    public static void main(String[] args) {
       SpringApplication.run(WechatApplication.class, args);
    }
}