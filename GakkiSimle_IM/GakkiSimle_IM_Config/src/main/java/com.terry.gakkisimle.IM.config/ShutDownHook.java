package com.terry.gakkisimle.IM.config;

import net.sf.ehcache.constructs.web.ShutdownListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShutDownHook {
    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean(){
        System.out.println("初始化Ecache关闭监听程序");
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();
        servletListenerRegistrationBean.setListener(new ShutdownListener());
        return servletListenerRegistrationBean;
    }
}