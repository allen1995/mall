package com.allen.springbootaurhority;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan( value = "com.allen.springbootaurhority.dao")
public class SpringbootaurhorityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootaurhorityApplication.class, args);
    }

}
