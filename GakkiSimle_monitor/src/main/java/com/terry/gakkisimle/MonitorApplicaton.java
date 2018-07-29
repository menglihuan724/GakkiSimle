package com.terry.gakkisimle;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableAdminServer
@EnableDiscoveryClient
public class MonitorApplicaton {
    public static void main(String[] args) {
        SpringApplication.run(MonitorApplicaton.class, args);
    }
}