package com.example.dao.impl;

import com.example.anno.Bean;
import com.example.anno.Di;
import com.example.dao.UserDao;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

@Bean
public class UserDaoImpl implements UserDao {


    @Override
    public void add() {
        System.out.println("dao....");
    }
}
