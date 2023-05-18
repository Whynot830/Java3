package com.example.pw21.Aspects;

import com.example.pw21.Services.EmailService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@org.aspectj.lang.annotation.Aspect
@Component
public class EmailAspect {
    private EmailService emailService;

    public EmailAspect(EmailService emailService) {
        this.emailService = emailService;
    }

    @Pointcut("execution(* com.example.pw21.Services.*.createEntity(..)) || execution(* com.example.pw21.Services.*.updateEntity(..))")
    public void creationAndUpdateMethods() {}

    @AfterReturning(value = "creationAndUpdateMethods()")
    public void sendEmail(JoinPoint joinPoint) {
        Object object = joinPoint.getArgs()[0];
        String methodName = joinPoint.getSignature().getName();
        emailService.sendMail(methodName, object.toString());
    }
}
