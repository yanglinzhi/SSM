package com.ylz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    /*
     * 在tomcat10版本会报404错误，8.5则不会
     **/
    @RequestMapping("/")
    public String portal(){
        //将逻辑视图返回
        return "index";
    }

    @RequestMapping(
        value = {"/hello","/test"}
    )
    public String hello(){
        return "success";
    }
    @RequestMapping ("/test/a?c")
    public String test(){
        return "success";
    }
}
