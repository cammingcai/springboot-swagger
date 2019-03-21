package com.demo.bpp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author junhong
 */

// 这个参数设置的是beanIoc这个类本身bean的自定义beanName
@Configuration("beanI")
public class BeanIoc {

    @Bean
    public StudentService studentS1ervice() {
        // 在这里就是为了验证注入到spring IOC容器的名字到底是如何的，所以故意加了一个1
        // 通过结束bean的刷新监听事件打印出的beanName可以具体验证该操作是否可行
        return new StudentService();
    }

    @Bean
    public CustomContextEventRefresh customContextEventRefresh() {
        return new CustomContextEventRefresh();
    }

    @Bean
    public PeoplePropertiesPrefix peoplePropertiesPrefix() {
        return new PeoplePropertiesPrefix();
    }

    @Bean
    public ProductPropertiesPrefix productPropertiesPrefix() {
        return new ProductPropertiesPrefix();
    }

    @Bean("student")
    public StudentServiceWithCustomConstruct studentServiceWithCustomConstruct() {
        return new StudentServiceWithCustomConstruct("custom");
    }

    @Bean("SpringContextTool")
    public SpringApplicationContextAware springApplicationContextAware() {
        return new SpringApplicationContextAware();
    }

    @Bean("bean1")
    public Bean1 bean1() {
        return new Bean1();
    }

    @Bean("bean1_")
    public Bean2 bean2() {
        return new Bean2();
    }

    @Bean
    public CustomServletRequestHandledEventRefresh requestEvent() {
        return new CustomServletRequestHandledEventRefresh();
    }

    @Bean("swaggerDocker")
    public Docket docket() {

        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("Spring Boot Swagger DEMO")
                .description("学习swagger")
                .version("1.0")
                .build();

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.demo"))
                .paths(PathSelectors.any())
                .build();
    }

}
