package com.demo.bpp;

import org.springframework.beans.factory.config.AbstractFactoryBean;

/**
 * @author: junhong
 * @time: 18/1/24
 */
public class StudentFactoryBean extends AbstractFactoryBean<Object> {

    @Override
    public Class<?> getObjectType() {
        return Student.class;
    }

    @Override
    protected Object createInstance() throws Exception {
        Student student = new Student("factoryDemo", 18);
        return student;
    }

    @Override
    public String toString() {
        return "StudentFactoryBean";
    }
}
