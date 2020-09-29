package com.allen.springbootbase.config;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: allen
 * @Date: 2020-05-29 23:51
 * @Description:
 */
@Configuration
@ComponentScan(basePackages = "com.allen.springbootbase")
public class BaseConfig {

    @Bean
    public RateLimiter rateLimiter(){
        RateLimiter rateLimiter = RateLimiter.create(10);

        return rateLimiter;
    }
}
