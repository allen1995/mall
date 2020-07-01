package com.allen.springbootredis.distributedlock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @Auther: allen
 * @Date: 2020-06-20 09:29
 * @Description:
 */
@Component("redisDistributedLock")
public class RedisDistributedLock implements DistributedLock {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Resource(name = "lockscript")
    private DefaultRedisScript<Boolean> lockScript;

    @Resource(name = "unlockscript")
    private DefaultRedisScript<Boolean> unlockScript;

    @Override
    public boolean lock(String lockName, String value, String requestId) {
        for (;;){
            List<String> keys = Arrays.asList(lockName);
            boolean result = stringRedisTemplate.execute(lockScript, keys, value, requestId);
            if(result){
                return result;
            }
            Random random = new Random(300);
            try {
                Thread.sleep(random.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean unlock(String lockName, String value, String requestId) {
        List<String> keys = Arrays.asList(lockName);

        return stringRedisTemplate.execute(unlockScript, keys, value,requestId);
    }
}
