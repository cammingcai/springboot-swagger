package com.demo.bpp.aop3.execption;

/**
 * @author junhong
 */
public class HttpCodeExecption extends RuntimeException{

    public HttpCodeExecption(String message) {
        super(message);
    }
}
