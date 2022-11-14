package com.ylz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 杨霖志
 * @date 2022/9/22
 */
@RestController
public class TestInterceptorController {
    @RequestMapping("/test/interceptor")
    public String testInterceptor(){
        System.out.println(1/0);
        System.out.println("执行控制器方法testInterceptor()");
        return "success";
    }
}
