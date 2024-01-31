package com.example.service.impl;

import com.example.anno.Bean;
import com.example.anno.Di;
import com.example.dao.UserDao;
import com.example.service.UserService;
import org.springframework.stereotype.Service;

@Bean
public class UserServiceImpl implements UserService {

    @Di
    UserDao userDao;

    @Override
    public void add() {
        System.out.println("service...");
        userDao.add();
    }
}
