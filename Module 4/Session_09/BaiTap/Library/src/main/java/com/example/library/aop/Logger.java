package com.example.library.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class Logger {

    @AfterReturning("execution(* com.example.library.controller.BookController.borrow(..))")
    public void afterBorrow(JoinPoint joinPoint) {
        System.out.println("Borrow book" + joinPoint.getSignature().getName());
    }


    @AfterReturning("execution(* com.example.library.controller.BookController.giveBack(..))")
    public void afterGiveBack(JoinPoint joinPoint) {
        System.out.println("Give back book: " + joinPoint.getSignature().getName());
    }

    @AfterReturning("execution(* com.example.library.controller.BookController.list(..))")
    public void countViewer(JoinPoint joinPoint) {
        System.out.println("View count : " + joinPoint.getSignature().getName());
    }


}
