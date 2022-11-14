package com.ylz.config;

import org.springframework.web.filter.CharacterEncodingFilter;

import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * @author 杨霖志
 * @date 2022/9/22
 */
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * 设置一个配置类代替spring的配置文件
     */
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    /**
     * 设置一个配置类代替springMvc的配置文件
     */
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    /**
     *设置springMvc的前端控制器DispatcherServlet的url-pattern
     */
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     *设置当前过滤器
     */
    @Override
    protected Filter[] getServletFilters() {
        //创建编码过滤器
        CharacterEncodingFilter cef = new CharacterEncodingFilter("utf-8",true);
        //创建请求处理方式的过滤器
        HiddenHttpMethodFilter hf = new HiddenHttpMethodFilter();
        return new Filter[]{cef,hf};
    }
}
