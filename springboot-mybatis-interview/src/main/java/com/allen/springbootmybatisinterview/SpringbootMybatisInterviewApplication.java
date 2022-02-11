package com.allen.springbootmybatisinterview;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.allen.springbootmybatisinterview.mapper")
public class SpringbootMybatisInterviewApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisInterviewApplication.class, args);
    }

}
