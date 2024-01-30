package com.example.spring6.resource.dao.impl;

import com.example.spring6.resource.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository("myUserRedisDao")
public class UserRedisDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("dao redis ....");
    }
}
