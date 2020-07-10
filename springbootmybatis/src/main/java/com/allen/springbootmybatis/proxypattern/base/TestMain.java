package com.allen.springbootmybatis.proxypattern.base;

/**
 * @Auther: 20190598
 * @Date: 2020/7/10 16:10
 * @Description:
 */
public class TestMain {

    public static void main(String[] args) throws Exception {
        BaseService baseService = BaseServiceProxyFactory.build(Person.class);
        baseService.eat();
        baseService.toilet();
    }
}
