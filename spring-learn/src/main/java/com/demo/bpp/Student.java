package com.demo.bpp;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * @author junhong
 */

@Service("student")
public class Student {

    private int age;
    private String name;

    @Resource
    private Teacher teacher;

    private String factoryInvoke;

    public Student() {
        System.out.println("student construct run...");
    }

    public void init() {
        this.age = 18;
        this.name = "init";
        System.out.println("student init run...:" + toString());
    }

    @PostConstruct
    public void init2() {
        this.age = 18;
        this.name = "init2";
        System.out.println("student init2 run...:" + toString());
    }

    public void say() {
        System.out.println("我是一个学生:" + toString());
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFactoryInvoke(String factoryInvoke) {
        this.factoryInvoke = factoryInvoke;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", teacher=" + teacher +
                ", factoryInvoke='" + factoryInvoke + '\'' +
                '}';
    }
}
