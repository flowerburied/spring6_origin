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
//    private UserService userService;
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }

    //    第三种方式 构造方法注入
//    private UserService userService;
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    //    第四种方式 形参上注入
//    private UserService userService;
//    public UserController(@Autowired UserService userService) {
//        this.userService = userService;
//    }

    //    第五种方式 只有一个有参构造函数，无注解
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void add() {
        System.out.println("controller...");
        userService.add();
    }

}
