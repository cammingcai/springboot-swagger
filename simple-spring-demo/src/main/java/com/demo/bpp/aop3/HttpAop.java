package com.demo.bpp.aop3;

import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.demo.bpp.aop3.execption.HttpCodeExecption;
import com.demo.bpp.aop3.execption.HttpCommonExecption;
import com.demo.bpp.aop3.execption.HttpConnectExecption;
import com.demo.bpp.aop3.execption.HttpConnectTimeOutExecption;
import com.demo.bpp.aop3.execption.HttpSocketTimeOutExecption;

/**
 * @author junhong
 */

@Component
@Aspect
public class HttpAop {

    @Pointcut("execution(* com.demo.bpp.aop3.HttpWork.*(..))")
    public void http(){}

    @Around("http() && args(url)")
    public String get(ProceedingJoinPoint joinPoint, String url) {
        try {
            Object obj = joinPoint.proceed();
            return (String)obj;
        } catch (Throwable throwable) {
            if (throwable instanceof HttpSocketTimeOutExecption) {
                System.out.println("HttpSocketTimeOutExecption error with " + url);
            } else if (throwable instanceof HttpConnectTimeOutExecption) {
                System.out.println("HttpConnectTimeOutExecption error with " + url);
            } else if (throwable instanceof HttpCodeExecption) {
                System.out.println("HttpCodeExecption error with " + url + ", Error:" + throwable.getMessage());
            } else if (throwable instanceof HttpConnectExecption) {
                System.out.println("HttpConnectExecption error with " + url);
            } else if (throwable instanceof HttpCommonExecption) {
                System.out.println("HttpCommonExecption error with " + url + ", Error:" + throwable.getMessage());
            } else {
                System.out.println("HttpExecption error with " + url + ", Error:" + throwable.getMessage());
            }
        }
        return null;
    }


    @Around("http() && args(url, data)")
    public String post(ProceedingJoinPoint joinPoint, String url, Map<String, Object> data) {
        try {
            Object obj = joinPoint.proceed();
            return (String)obj;
        } catch (Throwable throwable) {
            if (throwable instanceof HttpSocketTimeOutExecption) {
                System.out.println("HttpSocketTimeOutExecption error with " + url);
            } else if (throwable instanceof HttpConnectTimeOutExecption) {
                System.out.println("HttpConnectTimeOutExecption error with " + url);
            } else if (throwable instanceof HttpCodeExecption) {
                System.out.println("HttpCodeExecption error with " + url + ", Error:" + throwable.getMessage());
            } else if (throwable instanceof HttpConnectExecption) {
                System.out.println("HttpConnectExecption error with " + url);
            } else if (throwable instanceof HttpCommonExecption) {
                System.out.println("HttpCommonExecption error with " + url + ", data: "
                        + JSON.toJSONString(data) + ", Error:" + throwable.getMessage());
            } else {
                System.out.println("HttpExecption error with " + url + ", data: "
                        + JSON.toJSONString(data) + ", Error:" + throwable.getMessage());
            }
        }
        return null;
    }

}
