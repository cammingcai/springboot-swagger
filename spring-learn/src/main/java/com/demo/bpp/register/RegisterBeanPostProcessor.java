package com.demo.bpp.register;

import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;

/**
 * @author junhong
 */

@Component
public class RegisterBeanPostProcessor implements BeanDefinitionRegistryPostProcessor{

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry)
            throws BeansException {
        BeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClassName("com.demo.bpp.School");
        beanDefinition.setAttribute("schoolName", "${schoolName}");

        registry.registerBeanDefinition("school1", beanDefinition);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
            throws BeansException {
        BeanDefinition bd = beanFactory.getBeanDefinition("school1");
        if (bd != null) {
            MutablePropertyValues mv = bd.getPropertyValues();
            Object obj = bd.getAttribute("schoolName");

            mv.add("schoolName", obj);
            // 这里通过上面的pv获取到了

        }

        Map map = beanFactory.getBeansOfType(PropertySourcesPlaceholderConfigurer.class);
        Iterator<Map.Entry<String, PropertySourcesPlaceholderConfigurer>> it = map.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<String, PropertySourcesPlaceholderConfigurer> entry = it.next();
            //String k = entry.getKey();
            PropertySourcesPlaceholderConfigurer pp = entry.getValue();
            //pp.setFileEncoding("UTF-8");
        }
    }
}
