package com.example.spring6.iocxml.bean.impl;

import com.example.spring6.iocxml.bean.UserDao;

public class PersonDaoImpl implements UserDao {
    @Override
    public void run() {
        System.out.println("PersonDaoImpl..");
    }
}
