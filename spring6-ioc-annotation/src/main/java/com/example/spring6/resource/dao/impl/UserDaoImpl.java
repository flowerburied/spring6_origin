package com.example.spring6.resource.dao.impl;

import com.example.spring6.resource.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository("myUserDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("dao执行。。。。");
    }
}
