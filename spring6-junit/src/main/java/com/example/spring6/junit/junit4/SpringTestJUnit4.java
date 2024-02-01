package com.example.spring6.junit.junit4;

import com.example.spring6.junit.junit5.User;
import jakarta.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean.xml")
public class SpringTestJUnit4 {

    @Resource
    User user;

    @Test
    public void testUser4() {
        System.out.println(user);
        user.run();
    }
}
