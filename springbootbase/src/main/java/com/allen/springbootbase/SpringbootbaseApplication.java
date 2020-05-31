package com.allen.springbootbase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class SpringbootbaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootbaseApplication.class, args);
	}

}
