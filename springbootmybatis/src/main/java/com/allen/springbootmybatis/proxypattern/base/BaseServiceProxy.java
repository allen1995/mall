package com.allen.springbootmybatis.proxypattern.base;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Auther: 20190598
 * @Date: 2020/7/10 16:02
 * @Description:
 */
public class BaseServiceProxy implements InvocationHandler {

    private final static String EAT = "eat";

    private final static String TOILET = "toilet";

    private BaseService baseService;

    public BaseServiceProxy(BaseService baseService) {
        this.baseService = baseService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object value = null;

        String methodName = method.getName();
        if( EAT.equals(methodName) ){
            wash();
            value = method.invoke(baseService,args);
        } else if ( TOILET.equals( methodName )){
            value = method.invoke(baseService, args);
            wash();
        }

        return value;
    }

    private void wash(){
        System.out.println("wash...");
    }
}
