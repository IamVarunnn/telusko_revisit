package com.varun.SpringBootRestJobApp_1.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    // return type, classname, method name, arguments

    @Before("execution(* com.varun.SpringBootRestJobApp_1.service.JobService.getJob(..)) || execution(* com.varun.SpringBootRestJobApp_1.service.JobService.updateJob(..))")
    public void logMethodCall(JoinPoint jp){
        logger.info("Method Called " + jp.getSignature().getName());
    }

    @After("execution(* com.varun.SpringBootRestJobApp_1.service.JobService.getJob(..)) || execution(* com.varun.SpringBootRestJobApp_1.service.JobService.updateJob(..))")
    public void logMethodExecuted(JoinPoint jp){
        logger.info("Method Executed " + jp.getSignature().getName());
    }

    @AfterThrowing("execution(* com.varun.SpringBootRestJobApp_1.service.JobService.getJob(..)) || execution(* com.varun.SpringBootRestJobApp_1.service.JobService.updateJob(..))")
    public void logMethodCrash(JoinPoint jp){
        logger.info("Method has issues " + jp.getSignature().getName());
    }

    @AfterReturning("execution(* com.varun.SpringBootRestJobApp_1.service.JobService.getJob(..)) || execution(* com.varun.SpringBootRestJobApp_1.service.JobService.updateJob(..))")
    public void logMethodExecutedSuccess(JoinPoint jp){
        logger.info("Method Executed Successfully " + jp.getSignature().getName());
    }
}
