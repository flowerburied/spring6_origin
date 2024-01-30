package com.example.spring6.iocxml.auto.service.impl;

import com.example.spring6.iocxml.auto.dao.impl.UserDaoImpl;
import com.example.spring6.iocxml.auto.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public void addUserService() {
        System.out.println("UserService执行。。。");
//        UserDaoImpl userDao = new UserDaoImpl();
//        userDao.addUseDao();
    }
}
