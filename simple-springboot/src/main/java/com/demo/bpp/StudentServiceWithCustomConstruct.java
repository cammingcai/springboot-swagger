package com.demo.bpp;

/**
 * @author junhong
 */
public class StudentServiceWithCustomConstruct {

    private String prefix;

    public StudentServiceWithCustomConstruct(String prefix) {
        this.prefix = prefix;
    }

    public String getName(Student student) {
        return student.getName();
    }

    public int getAge(Student student) {
        return student.getAge();
    }

}
