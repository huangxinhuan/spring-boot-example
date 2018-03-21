package com.example.demo;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class PerformanceMonitor {
    private static final Logger log = LoggerFactory.getLogger(PerformanceMonitor.class);

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    private void pointCutMethod(){}

    @Around("pointCutMethod()")
    public Object intercept(ProceedingJoinPoint joinPoint){
        long beginTick = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        log.info("start exec " + method.getName()+ "()");
        Object ret;
        try {
            ret = joinPoint.proceed();
            log.info("return : {}",ret);
        }catch (Throwable throwable){
            log.info("exception : ",throwable);
            Map<String,String> msg =  new HashMap<>();
            msg.put("message","error");
            ret = JSON.toJSONString(msg);
        }
        long cost = System.currentTimeMillis() - beginTick;
        log.info("end exec " + method.getName() + "(), TimeCost= " + cost + "ms");
        return ret;

    }


}
