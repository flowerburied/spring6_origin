package com.example.spring6.iocxml.auto.controller;

import com.example.spring6.iocxml.auto.service.UserService;
import com.example.spring6.iocxml.auto.service.impl.UserServiceImpl;

public class UserController {

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void addUser() {
        System.out.println("UserController执行。。。");
        userService.addUserService();
//        UserServiceImpl userService = new UserServiceImpl();
//        userService.addUserService();
    }

}
