package com.allen.springbootbase.controller;

import com.allen.springbootbase.component.Limiter;
import com.allen.springbootbase.module.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: allen
 * @Date: 2020-05-29 23:44
 * @Description:
 */
@RestController
public class BaseController {

    @Autowired
    private User user;

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Limiter
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(){
        return "hello,https";
    }

    @GetMapping("/getuser")
    public User getUser(){
        return user;
    }

    @PostMapping("/mykafka")
    public String testKafka(String message) {
        kafkaTemplate.send("mykafka", message);

        return "success";
    }
}
