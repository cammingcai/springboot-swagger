package com.demo.bpp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author junhong
 * 整个的SpringBoot启动入口，如下@SpringBootApplication就是
 * SpringBoot的自动配置相关注解，@ComponentScan则是包扫描的路径，
 * 其次包含了swagger的注解
 */

@SpringBootApplication
@ComponentScan("com.demo")
@EnableSwagger2
public class Bootstrap {

    public static void main(String[] args) {
        SpringApplication.run(Bootstrap.class);
    }

}