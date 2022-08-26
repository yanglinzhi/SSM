package com.ylz.spring.controller;

import com.ylz.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    public  void saveUser(){
        userService.saveUser();
    }
}
