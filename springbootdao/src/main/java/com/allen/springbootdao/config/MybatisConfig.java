package com.allen.springbootdao.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: allen
 * @Date: 2020-05-20 23:19
 * @Description:
 */
@Configuration
@MapperScan("com.allen.springbootdao.mbg.mapper")
public class MybatisConfig {
}
