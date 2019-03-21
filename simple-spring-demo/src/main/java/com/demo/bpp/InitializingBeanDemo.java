package com.demo.bpp;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author junhong
 * @time 18/5/9
 */

@Component("initializingBeanDemo")
public class InitializingBeanDemo implements InitializingBean, FactoryBean {

    public Object getObject() throws Exception {
        return "34";
    }

    public Class<?> getObjectType() {
        return String.class;
    }

    public boolean isSingleton() {
        return true;
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }
}
