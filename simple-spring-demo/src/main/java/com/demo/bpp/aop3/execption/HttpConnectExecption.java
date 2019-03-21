package com.demo.bpp.aop3.execption;

/**
 * @author junhong
 */
public class HttpConnectExecption extends RuntimeException {

    public HttpConnectExecption() {
    }

    public HttpConnectExecption(String message) {
        super(message);
    }
}
