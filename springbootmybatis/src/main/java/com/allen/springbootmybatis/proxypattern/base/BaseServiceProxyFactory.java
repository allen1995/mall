package com.allen.springbootmybatis.proxypattern.base;

import java.lang.reflect.Proxy;

/**
 * @Auther: 20190598
 * @Date: 2020/7/10 16:26
 * @Description:
 */
public class BaseServiceProxyFactory {

    private BaseServiceProxyFactory() {
    }

    public static BaseService build(Class classFile) throws Exception{
        if( classFile.isAssignableFrom(BaseService.class) ){
            throw new Exception("类型错误异常");
        }
        //创建业务对象
        BaseService baseService = (BaseService) classFile.newInstance();

        BaseServiceProxy advice = new BaseServiceProxy(baseService);

        BaseService $Proxy = (BaseService) Proxy.newProxyInstance(classFile.getClassLoader(), classFile.getInterfaces(), advice);

        return $Proxy;
    }

}
