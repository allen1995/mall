package com.allen.springbootmybatis.proxypattern.base;

/**
 * @Auther: 20190598
 * @Date: 2020/7/10 16:01
 * @Description:
 */
public class Person implements BaseService {
    @Override
    public void eat() {
        System.out.println("Person eat...");
    }

    @Override
    public void toilet() {
        System.out.println("Person toilet...");
    }
}
