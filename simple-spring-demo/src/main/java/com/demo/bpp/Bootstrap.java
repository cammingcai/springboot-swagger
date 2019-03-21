package com.demo.bpp;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import com.demo.bpp.BppBean.SuperStudent;
import com.demo.bpp.BppBean.Teacher;
import com.demo.bpp.aop.Animal;
import com.demo.bpp.aop2.Worker;
import com.demo.bpp.aop3.HttpWork;
import com.demo.bpp.cycle.Service1;
import com.demo.bpp.cycle.Service2;

/**
 * Created by junhong on 18/1/7.
 */
public class Bootstrap {

    private final static Logger logger = LoggerFactory.getLogger(Bootstrap.class);

    public static void fileTest() throws IOException {
        String path = "file://context.xml";

        //path = "xml/*.xml";
        path = "xml/hehe/context.xml";

        DefaultResourceLoader loader = new DefaultResourceLoader();
        Resource resource= loader.getResource(path);

        File file = resource.getFile();

        System.out.println(resource);
    }

    public static void run(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                new String[]{"context.xml"}, false);

        applicationContext.setAllowBeanDefinitionOverriding(true);
        applicationContext.refresh();

        Student student = (Student)applicationContext.getBean("studentFactory");
        System.out.println(student.toString());

        StudentFactoryBean studentFactoryBean = (StudentFactoryBean) applicationContext.getBean("&studentFactory");
        System.out.println(studentFactoryBean.toString());
    }

    public static void runClassPathTest(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                new String[]{"context.xml"});
    }

    public static void runFilePathTest(){
        String path = "context.xml";
        path = "simple-spring-demo/src/main/resources/context.xml";
        FileSystemXmlApplicationContext applicationContext = new FileSystemXmlApplicationContext(
                new String[]{path});


    }

    public static void runAopTest(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                new String[]{"context-normal.xml"});

        //People people = (People)applicationContext.getBean("people");
        //people.say();

        Animal animal = (Animal)applicationContext.getBean("animal");

        animal.sleep("xiao ming");

    }

    public static void runConfigTest(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);

        Student student = (Student) applicationContext.getBean("student");
        System.out.println(student);

    }

    public static void runPropertiesTest(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                new String[]{"context-properties.xml"});

        Student student = (Student) applicationContext.getBean("student");

        System.out.println(student.toString());
    }

    public static void runLogger(){
        logger.info("heheheheeh");
    }

    public static void runEventTest(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                new String[]{"context-event.xml"});
        while (true){

        }

        //EventDemoPublish publish = (EventDemoPublish)applicationContext.getBean("eventDemoPublish");
        //publish.publish("第一个消息");
        //publish.publish("第二个消息");
        //publish.publish("第三个消息");
        //publish.publish("第四个消息");
    }

    public static void runAop(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                new String[]{"context-aop.xml"});

        Worker work = (Worker) applicationContext.getBean("work");
        System.out.println(work.getClass().getName());

        //work.add("lisi");
        System.out.println(work.getWithCustomException());
        System.out.println(work.getWithRuntimeExecption());
        System.out.println(work.get());
        //work.get();
        //work.getWithRuntimeExecption();
        //work.add("zhangsan");
        //work.print();

    }

    public static void runBPP() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                new String[]{"context-bpp.xml"});

        SuperStudent student = (SuperStudent) applicationContext.getBean("superStudent");

        Teacher teacher = (Teacher) applicationContext.getBean("teacher");

        System.out.println(teacher.toString());

        System.out.println(student.toString());

        student.doSet();

        System.out.println(teacher.toString());
    }

    public static void runCycle() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                new String[]{"context-cycle.xml"});

        Service1 s1 = (Service1) applicationContext.getBean("s1");

        Service2 s2 = (Service2) applicationContext.getBean("s2");


        System.out.println("hehe");
    }

    public static void runHttpAop(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                new String[]{"context-http-aop.xml"});

        HttpWork work = (HttpWork) applicationContext.getBean("work");

        //work.httpGet("http://127.0.0.1:8080/index5.html");
        //
        //work.httpGet("http://127.0.0.1:8081/index5.html");

        Map<String, Object> map = new HashMap<>(2);
        map.put("age", "abc");
        work.httpPost("http://127.0.0.1:8080/indexPost", map);

        work.httpPost("http://127.0.0.1:8080/inde2xb1", map);
    }


    public static void main(String[] args){
        //runFilePathTest();
        //runAopTest();
        //runConfigTest();
        //run();
        //runPropertiesTest(); // classpath
        //runLogger();
        //runEventTest();
        //runAop();
        //runBPP();
        //runCycle();
        runHttpAop();
    }
}
