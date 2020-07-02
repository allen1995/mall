package com.allen.springbootjdbctemplate.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @Auther: 20190598
 * @Date: 2020/7/2 10:12
 * @Description:
 */
@Configuration
public class MyDatesourceConfig {

    @ConfigurationProperties( prefix = "spring.datasource.one")
    @Bean
    public DataSource dsOne(){
        return DruidDataSourceBuilder.create().build();
    }

    @ConfigurationProperties( prefix = "spring.datasource.two")
    @Bean
    public DataSource dsTwo(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    public JdbcTemplate oneJdbcTemplate(@Qualifier("dsOne") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public JdbcTemplate twoJdbcTemplate(@Qualifier("dsTwo") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
