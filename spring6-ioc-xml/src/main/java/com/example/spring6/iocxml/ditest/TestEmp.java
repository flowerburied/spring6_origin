package com.example.spring6.iocxml.ditest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestEmp {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-dilist.xml");

//        Emp emp3 = context.getBean("emp3", Emp.class);
//        emp3.work();

        Dept dept3 = context.getBean("dept3", Dept.class);
        dept3.info();

    }
}
