package com.demo.bpp.aop2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author junhong
 */

@Component("aop")
@Aspect
public class WorkAop {

    @Pointcut("execution(* com.demo.aop2.*.*())")
    public void pointCutNoParament(){}

    @Pointcut("execution(* com.demo.aop2.*.*(String))")
    public void pointCutWithParament(){}

    //@Before("pointCutNoParament()")
    public void before(){
        System.out.println("before");
    }

    @Before("pointCutWithParament()")
    @Order(100)
    public void before1(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        for(Object arg: args){
            System.out.println("before1 arg:[" + arg.getClass().getName() + "], " + arg.toString());
        }

        //System.out.println("before1: [" + name + "]");
    }

    @Around("pointCutNoParament()")
    public Object around(ProceedingJoinPoint joinPoint){
        try {
            System.out.println("around start");
            Object[] args = joinPoint.getArgs();
            for(Object arg: args){
                System.out.println("around arg:[" + arg.getClass().getName() + "], " + arg.toString());
            }
            Object obj = joinPoint.proceed();
            System.out.println("around end");
            return  "print[" + obj + "]";
        } catch (Throwable throwable) {
            if(throwable instanceof CustomExecption){
                return "CustomExecption" + throwable.getMessage();
            }
            if(throwable instanceof RuntimeException){
                return "RuntimeException" + throwable.getMessage();
            }
            return "Exception" + throwable.getMessage();
        }
    }

    @Around("pointCutWithParament() && args(name)")
    public Object around1(ProceedingJoinPoint joinPoint, String name){
        try {
            System.out.println("around1 start");

            Object obj = joinPoint.proceed();
            System.out.println("around1 end");
            return obj;
        } catch (Throwable throwable) {
        }
        return null;
    }

    @AfterReturning(pointcut = "pointCutWithParament()", returning = "returing")
    public void after(JoinPoint jp, Object returing){

    }
}
