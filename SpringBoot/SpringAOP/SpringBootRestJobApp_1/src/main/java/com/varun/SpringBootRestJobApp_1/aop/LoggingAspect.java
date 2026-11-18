package com.varun.SpringBootRestJobApp_1.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    // return type, classname, method name, arguments

    @Before("execution(* com.varun.SpringBootRestJobApp_1.service.JobService.*(..))")
    public void logMethodCall(){
        logger.info("Method Called");
    }
}
