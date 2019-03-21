package com.demo.bpp.aop3.execption;

/**
 * @author junhong
 */
public class HttpCommonExecption extends RuntimeException{

    public HttpCommonExecption() {
    }

    public HttpCommonExecption(String message) {
        super(message);
    }
}
