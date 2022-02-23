package com.java.admin.aspect;

import com.java.admin.annotation.Dictionary;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Aspect
@Component
public class DictionaryAspect {
    @Pointcut("execution(* com.java.admin.controller.*.*(..))")
    public void dictionary(){}

    @Around("dictionary()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        Object result = proceedingJoinPoint.proceed();
        System.out.println("进入注解");
        this.parseObjectText(result);
        return result;
    }

    private void parseObjectText(Object o){

    }
}
