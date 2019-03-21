package com.demo.bpp.factory;

import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

/**
 * @author junhong
 */

@Component
public class PriorityOrderedBeanFactoryPostProcessor implements BeanFactoryPostProcessor,
        PriorityOrdered {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
            throws BeansException {
        Map map = beanFactory.getBeansOfType(PropertySourcesPlaceholderConfigurer.class);
        Iterator<Map.Entry<String, PropertySourcesPlaceholderConfigurer>> it = map.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<String, PropertySourcesPlaceholderConfigurer> entry = it.next();
            //String k = entry.getKey();
            PropertySourcesPlaceholderConfigurer pp = entry.getValue();
            pp.setFileEncoding("UTF-8");
        }
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
