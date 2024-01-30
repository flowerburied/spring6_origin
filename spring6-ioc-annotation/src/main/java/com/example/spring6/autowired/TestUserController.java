package com.example.spring6.autowired;

import com.example.spring6.autowired.controller.UserController;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserController {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        UserController bean = context.getBean(UserController.class);
        bean.add();
//        System.out.println("bean" + bean);

    }
}
