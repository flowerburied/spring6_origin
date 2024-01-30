package com.example.spring6.autowired.service.impl;

import com.example.spring6.autowired.dao.UserDao;
import com.example.spring6.autowired.dao.impl.UserDaoImpl;
import com.example.spring6.autowired.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("service执行。。。");
        userDao.add();

    }
}
