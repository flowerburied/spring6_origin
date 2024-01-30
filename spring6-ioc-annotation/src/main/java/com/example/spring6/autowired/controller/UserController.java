package com.example.spring6.autowired.controller;

import com.example.spring6.autowired.service.UserService;
import com.example.spring6.autowired.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    //注入service
    //第一种方式
//    @Autowired  //根据类型找到对应的对象，完成注入
//    private UserService userService;

    //第二种方式 set
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void add() {
        System.out.println("controller...");
        userService.add();
    }

}
