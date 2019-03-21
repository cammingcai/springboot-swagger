package com.demo.bpp.aop;

/**
 * @author: junhong
 * @time: 18/2/3
 */

public class AnimalImpl implements Animal {

    public AnimalImpl() {
        System.out.println("init");
    }

    public void sleep(String name) {
        System.out.println(name + " sleep");
    }
}
