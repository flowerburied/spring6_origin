package com.example.spring6.resource.service.impl;

import com.example.spring6.resource.dao.UserDao;
import com.example.spring6.resource.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("myUserService")
public class UserServiceImpl implements UserService {

    @Resource
    UserDao myUserDao;

    @Override
    public void add() {
        System.out.println("service执行。。。");
        myUserDao.add();

    }
}
