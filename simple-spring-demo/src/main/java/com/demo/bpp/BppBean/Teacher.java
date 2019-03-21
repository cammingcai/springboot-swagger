package com.demo.bpp.BppBean;

import org.springframework.stereotype.Component;

/**
 * Created by junhong on 18/1/21.
 */

@Component
public class Teacher {

    private String name;
    private int age;

    public Teacher() {
        this.age = 20;
        System.out.println("this is a teacher");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "com.demo.bean.Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
