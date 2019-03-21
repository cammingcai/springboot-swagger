package com.demo.bpp.BppBean;

import javax.annotation.Resource;

/**
 * @author junhong
 */

public class SuperStudent {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Resource
    private Teacher teacher;

    public void doInit() {
        System.out.println("superstudent init");
    }

    public void doSet() {
        if (teacher != null) {
            teacher.setAge(19);
            teacher.setName("superStudent");
            System.out.println(teacher.toString());
        } else {
            System.out.println("teacher is null");
        }
    }

    @Override
    public String toString() {
        return "SuperStudent{" +
                "name='" + name + '\'' +
                ", teacher=" + teacher +
                '}';
    }
}
