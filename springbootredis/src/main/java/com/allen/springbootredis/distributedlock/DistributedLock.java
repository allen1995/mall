package com.allen.springbootredis.distributedlock;

/**
 * @Auther: allen
 * @Date: 2020-06-19 21:06
 * @Description:
 */
public interface DistributedLock {

    boolean lock(String lockName,String value,String requestId);

    boolean unlock(String lockName,String value,String requestId);
}
