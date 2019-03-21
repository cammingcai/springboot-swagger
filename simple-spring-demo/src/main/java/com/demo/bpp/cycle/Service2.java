package com.demo.bpp.cycle;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * @author junhong
 */

@Service("s2")
public class Service2 {

    @Resource
    private Service1 s1;

    public  Service2() {
        System.out.println("Service2 init");
    }

}
