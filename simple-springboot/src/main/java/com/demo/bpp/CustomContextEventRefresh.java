package com.demo.bpp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @author junhong
 */
public class CustomContextEventRefresh implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext applicationContext = (ApplicationContext)event.getSource();

        for(String name: applicationContext.getBeanDefinitionNames()){
            //String className = applicationContext.getBean(name).getClass().getName();
            System.out.println("====loading bean====[" + name + "]");
        }
        System.out.println("end...");
    }
}
