package com.terry.gakkisimle.IM.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @Description:
 * @Author:TERRY_MENG
 * @Date:2018-07-30
 */
@Configuration
public class RouterConfig {
    @Bean
    public RouterFunction<ServerResponse> timerRouter() {
        return route(GET("/time"), TimeHandler::getTime)
                .andRoute(GET("/date"), TimeHandler::getDate)
                .andRoute(GET("/times"), TimeHandler::sendTimePerSec);
    }
}
