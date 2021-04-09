package com.example.library.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class Logger {

    @AfterReturning("execution(* com.example.library.controller.BookController.getBorrow(..))")
    public void afterBorrow(JoinPoint joinPoint) {
        System.out.println("Borrow book" + joinPoint.getTarget());
    }


    @AfterReturning("execution(* com.example.library.controller.BookController.giveBack(..))")
    public void afterGiveBack(JoinPoint joinPoint) {
        System.out.println("Give back book: " + joinPoint.getTarget());
    }
}
