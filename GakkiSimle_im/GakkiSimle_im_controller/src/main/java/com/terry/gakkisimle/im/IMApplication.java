package com.terry.gakkisimle.im;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import tk.mybatis.spring.annotation.MapperScan;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;


/**
 * Created by terrymeng
 * IM启动类
 */

@EnableEurekaClient
@SpringBootApplication(scanBasePackages = "com.terry.gakkisimle.im")
@EntityScan(basePackages = {"com.terry.gakkisimle.wechat.entity.po", "com.terry.gakkisimle.im.entity.po"})
@EnableFeignClients

//@EnableJpaRepositories(basePackages = "com.terry.gakkisimle.im.dao")
@MapperScan("com.terry.gakkisimle.im.mapper")
public class IMApplication {
    public static void main(String[] args) {
        SpringApplication.run(IMApplication.class, args);
    }

}

@EnableAsync
@Configuration
class TaskPoolConfig {

    @Bean("taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        /*核心线程数*/
        executor.setCorePoolSize(10);
        /*最大线程数*/
        executor.setMaxPoolSize(20);
        executor.setQueueCapacity(200);
        /*除开核心线程的线程销毁时间*/
        executor.setKeepAliveSeconds(60);
        /*优雅关机*/
        executor.setWaitForTasksToCompleteOnShutdown(true);
        /*销毁时间,防止阻塞*/
        executor.setAwaitTerminationSeconds(60);
        executor.setThreadNamePrefix("taskExecutor-");
        /*拒绝任务策略*/
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }
}
