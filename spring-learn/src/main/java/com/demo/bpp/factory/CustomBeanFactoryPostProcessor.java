package com.demo.bpp.factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author junhong
 */

@Component
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
            throws BeansException {
        //Iterator<String> it = beanFactory.getBeanNamesIterator();
        //while (it.hasNext()) {
        //    System.out.println("CustomBeanFactoryPostProcessor===> " + it.next());
        //}

        // 通过这个操作可以自定义往bean注入各种各样需要的数据
        BeanDefinition bd = beanFactory.getBeanDefinition("student");
        if (bd != null) {
            MutablePropertyValues pv = bd.getPropertyValues();
            pv.add("factoryInvoke", "through beanfactorypostprocessor invoke");
        }



    }
}
