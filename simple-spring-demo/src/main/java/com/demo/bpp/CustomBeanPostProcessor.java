package com.demo.bpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by junhong on 18/1/17.
 */

//@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof Student){
            System.out.println("postProcessBeforeInitialization bean : " + beanName + " beanClass" + bean.toString());
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof Student){
            System.out.println("postProcessAfterInitialization bean : " + beanName + " beanClass" + bean.toString());
        }
        return bean;
    }
}
