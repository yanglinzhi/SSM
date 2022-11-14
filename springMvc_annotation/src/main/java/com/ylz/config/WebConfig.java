package com.ylz.config;

import com.ylz.interceptor.FirstInterception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import java.util.List;
import java.util.Properties;

/**
 * @author 杨霖志
 * @date 2022/9/22
 * Description:代替springMvc配置文件
 * 扫描组件、视图解析器、默认的servlet，mvc注解驱动
 * 视图控制器、文件上传解析器、拦截器、异常解析器
 */
@Configuration   //将当前类表示为配置类
@ComponentScan({"com.ylz.controller", "com.ylz.interceptor"}) //扫描组件
@EnableWebMvc //开启Mvc的注解驱动

public class WebConfig implements WebMvcConfigurer {
    @Autowired
    FirstInterception firstInterception;

    /**
     * 默认servlet处理静态资源
     *
     * @param configurer
     */
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * 设置视图解析器
     *
     * @param registry
     */
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }

    /**
     * @return
     * @bean 可以将表示的方法的返回值作为bean进行管理，bean的id为方法的方法名
     */
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        return new CommonsMultipartResolver();
    }

    /**
     * 添加拦截器
     *
     * @param registry
     */
    public void addInterceptors(InterceptorRegistry registry) {
        //add添加，exclude排除
        registry.addInterceptor(firstInterception).addPathPatterns("/*").excludePathPatterns();
    }

    /**
     * 配置异常解析器
     *
     * @param resolvers
     */
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        SimpleMappingExceptionResolver expressionResolver = new SimpleMappingExceptionResolver();
        Properties properties = new Properties();
        properties.setProperty("java.lang.ArithmeticException", "error");
        expressionResolver.setExceptionMappings(properties);
        expressionResolver.setExceptionAttribute("ex");
        resolvers.add(expressionResolver);
    }

    //配置生成模板解析器
    @Bean
    public ITemplateResolver templateResolver() {
        WebApplicationContext webApplicationContext =
                ContextLoader.getCurrentWebApplicationContext();
        // ServletContextTemplateResolver需要一个ServletContext作为构造参数，可通过WebApplicationContext 的方法获得
        ServletContextTemplateResolver templateResolver = new
                ServletContextTemplateResolver(
                webApplicationContext.getServletContext());
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        return templateResolver;
    }

    //生成模板引擎并为模板引擎注入模板解析器
    @Bean
    public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver) {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        return templateEngine;
    }

    //生成视图解析器并未解析器注入模板引擎
    @Bean
    public ViewResolver viewResolver(SpringTemplateEngine templateEngine) {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setCharacterEncoding("UTF-8");
        viewResolver.setTemplateEngine(templateEngine);
        return viewResolver;
    }

}
