package com.ylz.spring.proxy;

import com.ylz.spring.proxy.impl.CalculatorImpl;
import org.junit.Test;


public class ProxyTest {
    /**
     * 动态代理有两种：
     * 1.jdk动态代理：要求必须有接口,最终生成的代理类和目标类实现相同的接口,在com.sun.proxy包下，类名为$proxy加数字
     * 2.cglib动态代理：最终生成的代理类会继承目标类，并且和目标类在相同的包下
     */
    @Test
    public void testProxy(){

        /*ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-proxy.xml");
        CalculatorStaticProxy proxy = ioc.getBean(CalculatorStaticProxy.class);
        proxy.add(5,6);*/

        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator) proxyFactory.getProxy();
        proxy.add(1,2);
        //proxy.div(1,0);

    }

}
