package com.demo.bpp.cycle;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * @author junhong
 */

@Service("s1")
public class Service1 {

    @Resource
    private Service2 s2;

    public  Service1() {
        System.out.println("Service1 init");
    }
}
