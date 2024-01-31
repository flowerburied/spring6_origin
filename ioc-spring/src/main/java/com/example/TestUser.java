package com.example;

import com.example.bean.ApplicationContext;
import com.example.bean.impl.AnnotationApplicationContext;
import com.example.service.UserService;

public class TestUser {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationApplicationContext("com.example");
        UserService userService = (UserService) context.getBean(UserService.class);
        userService.add();

    }
}
