package com.allen.springbootbase.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.util.concurrent.RateLimiter;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: 20190598
 * @Date: 2020/9/18 10:18
 * @Description:
 */
@Aspect
@Component
public class RateLimiterAspect {

    @Autowired
    private RateLimiter rateLimiter;

    /**
     * 日志类
     */
    private static final Logger LOG = LoggerFactory.getLogger(RateLimiterAspect.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Pointcut(value = "@annotation(com.allen.springbootbase.component.Limiter)")
    public void pointCut(){}

    @Around(value = "pointCut()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        LOG.info("===>check access token:{}", joinPoint.getArgs());

        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();

        if( rateLimiter.tryAcquire()){
            if( LOG.isInfoEnabled() ){
                LOG.info(joinPoint.getSignature().getName() + " acquire access token.");
            }
            Object o  = joinPoint.proceed();
            return o;
        } else {
            try( PrintWriter out = response.getWriter();) {
                response.setStatus(500);
                response.setContentType("application/json;charset=utf-8");

                Map<String,Object> msgMap = new HashMap<>();
                msgMap.put("errorMsg","超出服务器最大负载！");

                out.write(objectMapper.writeValueAsString(msgMap));
                out.flush();
            }

        }

        return null;
    }
}
