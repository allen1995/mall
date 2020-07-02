package com.allen.springbootmybatis.config;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Auther: 20190598
 * @Date: 2020/7/2 10:47
 * @Description:
 */
@Configuration
@MapperScan(  value = "com.allen.springbootmybatis.mapper1", sqlSessionFactoryRef = "sqlSessionFactoryBean1")
public class MybatisConfigOne {

    @Autowired
    @Qualifier("dsOne")
    DataSource dsOne;

    @Bean
    SqlSessionFactory sqlSessionFactoryBean1() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dsOne);
        return factoryBean.getObject();
    }

    @Bean
    SqlSessionTemplate sqlSessionTemplate1() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactoryBean1());
    }
}
