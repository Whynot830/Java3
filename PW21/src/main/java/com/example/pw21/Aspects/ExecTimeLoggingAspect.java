package com.example.pw21.Aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
@org.aspectj.lang.annotation.Aspect

public class ExecTimeLoggingAspect {
    @Around("allServiceMethods()")
    public Object logging(ProceedingJoinPoint joinPoint) {
        long start = System.currentTimeMillis();
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable t) {
            log.info(t.getMessage(), t);
        }
        long end = System.currentTimeMillis();
        log.info("Method {} with parameters {} from {} class executed. Duration = {}ms",
                joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs()),
                joinPoint.getTarget().getClass().getSimpleName(),
                end - start
        );
        return result;
    }

    @Pointcut("within(com.example.pw21.Services.*)")
    public void allServiceMethods() {
    }
}
