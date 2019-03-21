package com.demo.bpp.aop3.execption;

/**
 * @author junhong
 */
public class HttpConnectTimeOutExecption extends RuntimeException {

    public HttpConnectTimeOutExecption() {
    }

    public HttpConnectTimeOutExecption(String message) {
        super(message);
    }
}
