package com.demo.bpp.aop3.execption;

/**
 * @author junhong
 */
public class HttpSocketTimeOutExecption extends RuntimeException {

    public HttpSocketTimeOutExecption() {
    }

    public HttpSocketTimeOutExecption(String message) {
        super(message);
    }
}
