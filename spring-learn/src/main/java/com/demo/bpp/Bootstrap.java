package com.demo.bpp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author junhong
 */


public class Bootstrap {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                new String[]{"spring/spring-context.xml"});

        Student student = (Student) applicationContext.getBean("student");
        student.say();

        School school = (School) applicationContext.getBean("school1");
        System.out.println(school.toString());
    }

}
