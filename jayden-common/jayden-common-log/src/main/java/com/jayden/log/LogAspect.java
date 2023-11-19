package com.jayden.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Slf4j
@Component
@ConditionalOnProperty(name = "log.aspect.enable",havingValue = "true",matchIfMissing = true)
public class LogAspect {

    /**
     * 切入点方法
     */
    @Pointcut("execution(* com.jayden.*.controller.*Controller.*(..)) || execution(* com.jayden.*.service.*Service.*(..))")
    public void logPointCut() {
    }

    /**
     * 环绕通知
     * 注意：切面方法中不能有异常捕获的逻辑，否则会导致业务异常被吞掉
     */
    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long time = System.currentTimeMillis() - startTime;
        log.info("方法名：{}，参数：{}，耗时：{}ms", joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()), time);
        return result;
    }
}
