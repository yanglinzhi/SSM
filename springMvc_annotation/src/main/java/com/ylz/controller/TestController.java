package com.ylz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 杨霖志
 * @date 2022/9/22
 */
@Controller
public class TestController {
    @RequestMapping("/test/interceptor")
    public String testInterceptor(){
        System.out.println("执行控制器方法testInterceptor()");
        return "success";
    }
    @RequestMapping("/test/error")
    public String testError() {
        System.out.println(1/0);
        return "success";
    }

}
