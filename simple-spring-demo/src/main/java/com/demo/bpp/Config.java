package com.demo.bpp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author: junhong
 * @time: 18/3/14
 */

@Configuration
@ImportResource("classpath:context-config.xml")
public class Config {

    public Config() {
        System.out.println("config loading");
    }

    @Bean(initMethod = "init")
    public Student student(){
        return new Student("34", 1);
    }
}
