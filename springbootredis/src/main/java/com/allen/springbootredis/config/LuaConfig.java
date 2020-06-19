package com.allen.springbootredis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;

/**
 * @Auther: 20190598
 * @Date: 2020/6/19 16:32
 * @Description:
 */
@Configuration
public class LuaConfig {

    @Bean
    public DefaultRedisScript<Boolean> distributedlockScript(){
        DefaultRedisScript<Boolean> defaultRedisScript = new DefaultRedisScript<>();
        defaultRedisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("static/script/distributedlock.lua")));
        defaultRedisScript.setResultType(Boolean.class);

        return defaultRedisScript;
    }
}
