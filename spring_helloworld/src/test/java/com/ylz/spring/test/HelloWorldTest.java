package com.ylz.spring.test;

import com.ylz.spring.pojo.HelloWorld;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldTest {
    @Test
    public void test(){
        //获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("application.xml");
        //获取IOC容器中的bean对象
        HelloWorld hello = (HelloWorld) ioc.getBean("hello");
        hello.sayHello();
    }
}
