package com.allen.springbootredis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: 20190598
 * @Date: 2020/6/19 16:36
 * @Description:
 */
@RestController
public class LockController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Resource(name = "lockscript")
    private DefaultRedisScript defaultRedisScript;

    @GetMapping("/lua")
    public ResponseEntity lua(String requestId){
        List<String> keys = new ArrayList<>(Arrays.asList("order_lock"));
        Boolean result = (Boolean) stringRedisTemplate.execute(defaultRedisScript, keys, "10010",requestId);
        return ResponseEntity.ok(result);
    }
}
