package com.demo.bpp.aop1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author: junhong
 * @time: 18/2/3
 */

@Aspect
public class AnimalAop2 {

    @Pointcut("execution(* com.demo.aop.*.*(..)) && args(name)")
    public void pointCut(String name){}

    @Around("pointCut(name)")
    public Object around(ProceedingJoinPoint pj, String name){
        Object obj = null;
        System.out.println(name + " around before 2");
        try {
            obj = pj.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println(name + " around after 2");
        return obj;
    }

    @Before("pointCut(name)")
    public void before(String name){
        System.out.println(name + " animal before 2");
    }

    @After("execution(* com.demo.aop.*.*(..))")
    public void after(){
        System.out.println("animal after 2");
    }

}
