package com.allen.springbootmybatis.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Auther: 20190598
 * @Date: 2020/7/2 10:44
 * @Description:
 */
@Configuration
public class MyDatasourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.one")
    public DataSource dsOne(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.two")
    public DataSource dsTwo(){
        return DruidDataSourceBuilder.create().build();
    }
}
