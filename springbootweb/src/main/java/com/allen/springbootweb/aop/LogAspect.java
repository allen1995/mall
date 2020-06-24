package com.allen.springbootweb.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: 20190598
 * @Date: 2020/6/24 14:52
 * @Description:
 */
@Component
@Aspect
public class LogAspect {

    @Pointcut("execution(* com.allen.springbootweb.aop.*.*(..))")
    public void pointCut(){}

    @Before(value = "pointCut()")
    public void before(JoinPoint jp){
        String name = jp.getSignature().getName();
        System.out.println(name + " 方法开始执行之前");
    }

    @After(value = "pointCut()")
    public void after(JoinPoint jp){
        String name = jp.getSignature().getName();
        System.out.println(name + " 方法执行之后");
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void afterReturning(JoinPoint jp, Object result){
        String name = jp.getSignature().getName();
        System.out.println(name + " 方法正常返回, 结果是：" + result);
    }

    @AfterThrowing(value = "pointCut()", throwing = "e")
    public void afterThrowing(JoinPoint jp, Exception e){
        String name = jp.getSignature().getName();
        System.out.println(name + " 方法异常返回,异常原因：" + e);
    }

    //@Around(value = "pointCut()")
    //public void around(ProceedingJoinPoint pj) throws Throwable {
    //    System.out.println("around>>方法执行之前");
    //    pj.proceed();
    //    System.out.println("around>>方法执行之后");
    //}
}
