package com.ylz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 杨霖志
 * @date 2022/9/15
 *
 *
 * 查询所有用户信息-->/user-->get
 * 根据id查询用户信息-->/user/{id}-->get
 * 添加用户信息-->/user-->post
 * 修改用户信息-->/user-->put
 * 删除用户信息-->/user/{id}-->delete
 *
 *
 */
@Controller
public class TestRestController {
    //查询所有用户信息
    @GetMapping("/user")
    public String getUsers() {
        System.out.println("查询所有用户信息-->/user-->get");
        return "success";
    }
}
