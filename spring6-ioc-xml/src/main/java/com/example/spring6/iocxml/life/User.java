package com.example.spring6.iocxml.life;

public class User {
    private String name;

    //    无参构造
    public User() {
        System.out.println("1、bean对象创建(调用无参数构造)");
    }

    //    初始化方法
    public void initMethod() {
        System.out.println("4、bean对象初始化(调用指定初始化方法)");
    }

    //    销毁方法
    public void destructionMethod() {
        System.out.println("7、bean对象销毁(配置指定销毁的方法)");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("2、给bean对象设置相关属性");
        this.name = name;
    }
}
