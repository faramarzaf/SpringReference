package com.faramarz.spring.aop.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AfterAopAspect {

    @AfterReturning(value = "execution(*  com.faramarz.spring.aop.business.*.*(..))"
            , returning = "result"
    )
    public void after(JoinPoint joinPoint, Object result) {
        System.out.println("AfterReturning --> " + joinPoint + "result= " + result);
    }


    @AfterThrowing(value = "execution(*  com.faramarz.spring.aop.business.*.*(..))"
            , throwing = "exception"
    )
    public void afterThrowing(JoinPoint joinPoint, Exception exception) {
        System.out.println("AfterThrowing --> " + joinPoint + "result= " + exception);
    }


}
