package com.example.spring6.aop.example;

import com.example.spring6.aop.example.impl.CalculatorImpl;

public class TestCalculator {

    public static void main(String[] args) {
        //动态方式创建代理对象
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator) proxyFactory.getProxy();

        proxy.add(1, 2);


    }
}
