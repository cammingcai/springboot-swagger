package com.demo.bpp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author: junhong
 * @time: 18/2/3
 */

@Aspect
public class AnimalAop {

    //@Pointcut("execution(* com.demo.Aop.*.*(..))")
    //public void pointCut(){}
    //
    //@Around("pointCut() && args(name)")
    //public Object around(ProceedingJoinPoint pj, String name){
    //    Object obj = null;
    //    System.out.println(name + " around before");
    //    try {
    //        obj = pj.proceed();
    //    } catch (Throwable throwable) {
    //        throwable.printStackTrace();
    //    }
    //    System.out.println(name + " around after");
    //    return obj;
    //}
    //
    //@Before("pointCut() && args(name)")
    //public void before(String name){
    //    System.out.println(name + " animal before");
    //}
    //
    //@After("execution(* com.demo.Aop.*.*(..))")
    //public void after(){
    //    System.out.println("animal after");
    //}

    @Before("execution(* com.demo.bpp.aop.AnimalImpl.*(..))")
    public void before(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        for(int i =0; i< args.length; i++){
            System.out.println(args[i].getClass().getName() + "," + args[i].toString());
        }
        System.out.println("before end...");
    }

    @Before("execution(* com.demo.aop.*.*(..))")
    public void before1(){
        System.out.println("before1 end...");
    }

}
