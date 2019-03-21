package com.demo.bpp;

import org.springframework.stereotype.Service;

/**
 * @author junhong
 */

@Service("teacher")
public class Teacher {

    private String name;

    public Teacher() {
        this.name = "alice";
        System.out.println("teacher constructor ...");
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                '}';
    }
}
