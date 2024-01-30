package com.example.spring6;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {

    //创建Logger对象
    private Logger logger = LoggerFactory.getLogger(TestUser.class);

    @Test
    public void testUserObject() {
        //加载spring配置文件，对象创建
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

//获取创建的对象
        User user = (User) context.getBean("user");
        System.out.println("user:" + user);

        user.add();

//        手动写日志
        logger.info("执行调用成功。。");

    }


    @Test
    public void testReflexObject() throws Exception {
//获取类class对象
        Class aClass = Class.forName("com.example.spring6.User");
//调用创建方法
//        Object o = aClass.newInstance();
        User user = (User) aClass.getDeclaredConstructor().newInstance();

        System.out.println("reflexUser:" + user);
    }
}
