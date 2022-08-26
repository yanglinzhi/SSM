package com.ylz.spring.test;

import com.ylz.spring.pojo.Student1;
import com.ylz.spring.pojo.Student2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCByXmlTest {
    /**
     * 获取bean的三种方式
     * 1.根据bean的id获取
     * 2.根据bean的类型获取
     *   根据类型获取bean时，要求ioc容器中有且只有一个该类型的bean
     * 3.根据类型和id来获取
     *   此时ioc容器里可以有多个类型的bean
     */

    @Test
    /**
     * 1.根据bean的id获取
     */
    public void getBeanById(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("application.xml");
        Student1 studentOne = (Student1) ioc.getBean("studentOne");
        System.out.println(studentOne);
    }
    /**
     * 2.根据bean的类型获取
     */
    @Test
    public void getBeanByClass(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("application.xml");
        Student1 studentOne = ioc.getBean(Student1.class);
        System.out.println(studentOne);
    }
    /**
     * 3.根据类型和id来获取
     */
    @Test
    public void getBeanByIdAndClass(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("application.xml");
        Student1 studentOne = ioc.getBean("studentOne", Student1.class);
        System.out.println(studentOne);
    }
    /**
     * setter注入
     * 构造器注入
     */
    @Test
    public void setter(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("application.xml");
        Student2 studentTwo = ioc.getBean("studentTwo", Student2.class);
        Student2 studentThree = ioc.getBean("studentThree", Student2.class);
        System.out.println(studentTwo);
        System.out.println(studentThree);
    }

}
