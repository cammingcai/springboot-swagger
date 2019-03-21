package com.demo.bpp.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author: junhong
 * @time: 18/2/2
 */
public class PeopleAop {

    public void before(){
        System.out.println("before");
    }

    public void after(){
        System.out.println("after");
    }

    public Object around(ProceedingJoinPoint pj){

        System.out.println("around before");
        Object obj = null;
        try {
            obj = pj.proceed();
        } catch (Throwable throwable) {

        }
        System.out.println("around after");
        return obj;
    }

    public void afterReturn(){
        System.out.println("after return");
    }

    public void excep(){
        System.out.println("error!!!!");
    }

}
