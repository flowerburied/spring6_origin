package com.example.spring6.iocxml.scope;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestOrders {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean-scope.xml");
        Orders orders = context.getBean("orders", Orders.class);
        System.out.println("orders..." + orders);
        Orders orders1 = context.getBean("orders", Orders.class);
        System.out.println("orders1..." + orders1);
    }
}
