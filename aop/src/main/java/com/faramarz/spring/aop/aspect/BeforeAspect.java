package com.faramarz.spring.aop.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class BeforeAspect {


    // before format -->   execution(* PACKAGE.*.*(..))

    /**
     * PACKAGE --> in specific package
     * first   --> any return types
     * second   --> any class
     * third   --> intercept all method calls
     * (..) --> any kind of arguments
     * <p>
     * we add JoinPoint to method to get detail
     */

    /**
     * if  execution(* PACKAGE..*.*(..)) this will be perform on all subpackages
     * execution(*  com.faramarz.spring.aop..*.*(..))
     */

    @Before("execution(*  com.faramarz.spring.aop.business.*.*(..))")
    public void before(JoinPoint joinPoint) {
        System.out.println("intercepted method calls--> " + joinPoint);
    }


}
