package com.demo.bpp.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author junhong
 * @time 18/4/25
 */
@Component
public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        ApplicationContext applicationContext = (ApplicationContext)event.getSource();

        for(String name: applicationContext.getBeanDefinitionNames()){
            System.out.println("==== bean====" + name);
        }

        System.out.println("end...");
    }
}
