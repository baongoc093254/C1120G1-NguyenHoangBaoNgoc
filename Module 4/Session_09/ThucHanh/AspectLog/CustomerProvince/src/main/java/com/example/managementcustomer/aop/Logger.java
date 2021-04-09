package com.example.managementcustomer.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class Logger {
    @After("execution(* com.example.managementcustomer.service.impl.CustomerServiceImpl.save(..))")
    public void afterCallMethod(JoinPoint joinPoint) {
        System.out.println("Done method : " + joinPoint.getSignature().getName());
    }
}
