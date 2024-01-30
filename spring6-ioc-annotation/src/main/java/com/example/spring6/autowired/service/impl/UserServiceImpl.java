package com.example.spring6.autowired.service.impl;

import com.example.spring6.autowired.dao.UserDao;
import com.example.spring6.autowired.dao.impl.UserDaoImpl;
import com.example.spring6.autowired.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
//    @Autowired
//    private UserDao userDao;

//    private UserDao userDao;
//    @Autowired
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

//    private UserDao userDao;
//    @Autowired
//    public UserServiceImpl(UserDao userDao) {
//        this.userDao = userDao;
//    }


//    private UserDao userDao;
//    public UserServiceImpl(@Autowired UserDao userDao) {
//        this.userDao = userDao;
//    }

    //    第六种方式，使用两个注解，根据名称进行注入
    @Qualifier(value = "userRedisDaoImpl")
    @Autowired
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("service执行。。。");
        userDao.add();

    }
}
