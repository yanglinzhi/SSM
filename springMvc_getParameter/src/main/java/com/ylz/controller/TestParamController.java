package com.ylz.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


/**
 * 获取参数的方式:
 *  1.用过servletAPI进行获取
 *      只需要在控制器方法的形参位置设置HttpServletRequest类型的形参就可以在控制器方法中使用request对象获取请求参数
 *  2.通过控制器方法形参获取
 *      只需要在控制器方法的形参位置设置一个形参，形参的名字和请求参数的名字一致即可
 *
 *
 *
 */
@Controller
public class TestParamController {
    @RequestMapping("/")
    public String portal(){
        //将逻辑视图返回
        return "index";
    }


    @PostMapping("/param/servletAPI")
    public String getParamByServletAPI(HttpServletRequest request){
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:" + userName + ",password:" + password);
        return "success";
    }

    @PostMapping("/param")
    public String getParam(String username,String password){
        System.out.println("username:" + username + ",password:" + password);
        return "success";
    }
}
