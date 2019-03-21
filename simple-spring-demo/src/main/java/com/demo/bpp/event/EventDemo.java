package com.demo.bpp.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author: junhong
 * @time: 18/3/22
 */
public class EventDemo extends ApplicationEvent {

    private String message;

    public EventDemo(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
