package com.accolite.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Before("execution (public * com.accolite.ModelAop.ShapeHolder.getShape1())")
    public void logMessage(JoinPoint joinPoint){
        System.out.println("Getter has been called! " + joinPoint.toLongString());
    }
}
