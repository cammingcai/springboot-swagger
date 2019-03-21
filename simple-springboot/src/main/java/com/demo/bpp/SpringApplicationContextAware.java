package com.demo.bpp;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author junhong
 */
public class SpringApplicationContextAware implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // 通过这种形式就获取到了Spring 本身的上下文内容了
        SpringApplicationContextAware.applicationContext = applicationContext;
    }

    public int getBeanCount() {
        // 获取了上下文之后，调用其方法获取bean的个数
        return applicationContext.getBeanDefinitionCount();
    }

    public String[] getBeanName() {
        return applicationContext.getBeanDefinitionNames();
    }
}
