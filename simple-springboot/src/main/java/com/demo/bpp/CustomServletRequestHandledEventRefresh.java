package com.demo.bpp;

import org.springframework.context.ApplicationListener;
import org.springframework.web.context.support.ServletRequestHandledEvent;
import org.springframework.web.servlet.FrameworkServlet;

import com.alibaba.fastjson.JSON;
import sun.rmi.runtime.Log;

import java.util.logging.Logger;

/**
 * @author junhong
 */
public class CustomServletRequestHandledEventRefresh implements ApplicationListener<ServletRequestHandledEvent> {

    @Override
    public void onApplicationEvent(ServletRequestHandledEvent event) {

        FrameworkServlet frameworkServlet = (FrameworkServlet)event.getSource();
        String clientAddress = event.getClientAddress();
        String desc = event.getDescription();
        String methodName = event.getMethod();
        String requestUrl = event.getRequestUrl();
        String servletName = event.getServletName();
        int statusCode = event.getStatusCode();
        long time = event.getTimestamp();

       // Logger.();
        System.out.println(JSON.toJSONString(event));
    }
}
