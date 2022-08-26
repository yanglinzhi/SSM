package com.ylz.spring.test;

import com.ylz.spring.controller.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowiredByXmlTest {
    /**
     * 自动装配：
     * 根据指定的策略在ioc容器中匹配某个bean，自动为bean中的类类型的属性或接口类型的属性赋值
     */
    @Test
    public void testAutowired(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-autowired-xml.xml");
        UserController userController = ioc.getBean(UserController.class);
        userController.saveUser();
    }
}
