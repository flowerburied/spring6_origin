package com.example.spring6.iocxml.auto.service.impl;

import com.example.spring6.iocxml.auto.dao.UserDao;
import com.example.spring6.iocxml.auto.dao.impl.UserDaoImpl;
import com.example.spring6.iocxml.auto.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUserService() {
        System.out.println("UserService执行。。。");
        userDao.addUseDao();
//        UserDaoImpl userDao = new UserDaoImpl();
//        userDao.addUseDao();
    }
}
