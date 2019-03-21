package com.demo.bpp.populate;

import java.beans.PropertyDescriptor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.core.Ordered;

/**
 * @author junhong
 */

// @Component
public class PopulateBeanPostProcessor implements InstantiationAwareBeanPostProcessor, Ordered {

    @Override
    public int getOrder() {
        return 9;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName)
            throws BeansException {
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName)
            throws BeansException {
        if ("student".equals(beanName)) {
            return false;
        }
        return true;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds,
            Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        System.out.println("PopulateBeanPostProcessor postProcessBeforeInitialization :" + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        System.out.println("PopulateBeanPostProcessor postProcessBeforeInitialization :" + beanName);
        return bean;
    }
}
