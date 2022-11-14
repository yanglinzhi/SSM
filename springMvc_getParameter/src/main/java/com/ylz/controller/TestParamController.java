package com.ylz.controller;


import com.ylz.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


/**
 * 获取参数的方式:
 *  1.用过servletAPI进行获取
 *      只需要在控制器方法的形参位置设置HttpServletRequest类型的形参就可以在控制器方法中使用request对象获取请求参数
 *  2.通过控制器方法形参获取
 *      只需要在控制器方法的形参位置设置一个形参，形参的名字和请求参数的名字一致即可
 *      若名字不对应，则需在形参位置添加@RequestParam映射
 *  3.@RequestParam的三个属性:value,required,defaultValue
 *      value:设置和形参绑定的请求参数的名字
 *      required:设置是否必须传输value对应的请求参数,默认值为true，表示value所对应的请求必须传输，否则页面报错400
 *      defaultValue:设置当没有传输value所对应的请求参数时，为形参设置的默认值
 *  4.RequestHeader:将请求头信息和控制器方法的形参绑定
 *  5.@CookieValue:将cookie数据和控制器方法的形参绑定
 *  6.通过实体类获取请求参数
 *  7.解决请求中的参数乱码问题
 *      tomcat 8以上版本无get请求乱码问题
 *      在web.xml中配置spring编码过滤器,一定要在其他过滤器之前,否则无效
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

    @PostMapping("/param1")
    public String getParamNew(@RequestParam("userName") String username, String password){
        System.out.println("username:" + username + ",password:" + password);
        return "success";
    }
    @GetMapping("/param/pojo")
    public String getParamByPojo(User user){
        System.out.println(user);
        return "success";
    }
}
