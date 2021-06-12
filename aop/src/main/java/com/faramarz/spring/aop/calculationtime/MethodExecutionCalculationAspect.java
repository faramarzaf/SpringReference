package com.faramarz.spring.aop.calculationtime;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class MethodExecutionCalculationAspect {

    /**
     * start time = x
     * allow execution of method
     * end time = y
     */

    /**
     * As you said, when you're using @Around it's just like you can do whatever you want before the method,
     * then invoke the method, then you can do whatever you want after the method called.
     * <p>
     * Read file, Log , .... (Before method calling)
     * Invoke the method (joinPoint.proceed)
     * Write to the file, complete log, .... (After method calling)
     * <p>
     * The invoking phase done by joinPoint.proceed().
     */

    @Around("execution(*  com.faramarz.spring.aop.business.*.*(..))")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();    // before execution
        joinPoint.proceed();    // execution
        long timeTaken = System.currentTimeMillis() - startTime;    // after execution
        System.out.println("Time taken by " + joinPoint + "is " + timeTaken);
    }

}
