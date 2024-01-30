package com.example.spring6.iocxml.auto.dao.impl;

import com.example.spring6.iocxml.auto.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public void addUseDao() {
        System.out.println("UserDao执行。。。");
    }
}
