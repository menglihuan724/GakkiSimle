package com.terry.gakkisimle.wechat.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @Author: Terry.Meng
 * @Date: Created in 18-2-12
 * @Description:
 */
@Configuration
@MapperScan(value = {"com.terry.gakkisimle.wechat.service.mapper"})
public class MyBaitsPlusConfig {
    //数据库1
    @Bean(name = "mysqlDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidDataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        return dataSource;
    }

    @Bean(name ="sessionFactory")
    @ConfigurationProperties(prefix = "mybatis-plus")
    @ConfigurationPropertiesBinding()
    public MybatisSqlSessionFactoryBean sqlSessionFactory(@Qualifier(value = "mysqlDataSource") DataSource dataSource) {
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("dialect", "mysql");
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        p.setProperty("reasonable", "true");
        p.setProperty("supportMethodsArguments", "true");
        p.setProperty("returnPageInfo", "check");
        p.setProperty("params", "count=countSql");
        pageHelper.setProperties(p);
        Interceptor[] interceptors = new Interceptor[]{pageHelper};
        bean.setPlugins(interceptors);
        return bean;
    }


}
