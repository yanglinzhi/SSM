package com.ylz.soring.aopAnnotation;

import com.ylz.spring.aopAnnotation.Calculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {
    @Test
    public void testAOP(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("aop-annotation.xml");
        Calculator calculator = ioc.getBean(Calculator.class);
        //calculator.div(1,0);
        calculator.add(5,2);
    }
}
