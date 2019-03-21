package com.demo.bpp.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author: junhong
 * @time: 18/3/22
 */

@Component
public class EventDemoListern implements ApplicationListener<EventDemo> {

    @Override
    public void onApplicationEvent(EventDemo event) {
        System.out.println("receiver " + event.getMessage());
    }
}
