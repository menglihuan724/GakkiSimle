package com.terry.gakkisimle.im.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.util.Date;

@EnableCaching
@Configuration
public class EcacheConfig {
    @Bean(name = "cacheManager")
    public EhCacheCacheManager ehCacheCacheManager(EhCacheManagerFactoryBean bean){

        EhCacheCacheManager ehCacheCacheManager=new EhCacheCacheManager(bean.getObject());
        return ehCacheCacheManager;

    }
    @Bean
    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean(){
        String temp=System.getProperty("java.io.tmpdir");
        Date now=new Date();
        File data=new File(temp+"/ehcache/test/test1.data");
        File index=new File(temp+"/ehcache/test/test1.index");
        data.setLastModified(now.getTime());
        index.setLastModified(now.getTime());
        System.out.println(String.format("修改缓存文件时间:%s",data.lastModified()==index.lastModified()));

        System.setProperty(net.sf.ehcache.CacheManager.ENABLE_SHUTDOWN_HOOK_PROPERTY,"true");

        EhCacheManagerFactoryBean cacheManagerFactoryBean = new EhCacheManagerFactoryBean();

        cacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));

        cacheManagerFactoryBean.setShared(true);

      //  cacheManagerFactoryBean.setAcceptExisting(true);

        return cacheManagerFactoryBean;

    }
}