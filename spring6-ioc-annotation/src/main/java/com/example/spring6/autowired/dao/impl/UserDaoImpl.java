package com.example.spring6.autowired.dao.impl;

import com.example.spring6.autowired.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("dao执行。。。。");
    }
}
