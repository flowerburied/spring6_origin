package com.example.reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

public class TestCar {


    //    获取class对象多种方式
    @Test
    public void test01() throws Exception {
//        类型class
        Class class1 = Car.class;
//对象.class
        Class class2 = new Car().getClass();
//Class.forName("全路径")
        Class class3 = Class.forName("com.example.reflect.Car");
//   实例化
        Car car = (Car) class3.getDeclaredConstructor().newInstance();
        System.out.println("car===" + car);
    }

    //获取构造方法
    @Test
    public void test02() throws Exception {
//        类型class
        Class class1 = Car.class;
//获取所有构造
        //.getConstructors(); 获取所有public的构造方法
//        .getDeclaredConstructors(); 获取所有的构造方法
//        Constructor[] constructors = class1.getConstructors();
        Constructor[] constructors = class1.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor.getName()
                    + "==="
                    + constructor.getParameterCount());
        }

//        指定有参数构造创建对象
//        构造public
//        Constructor c1 = class1.getConstructor(String.class, int.class, String.class);
//        Car car1 = (Car) c1.newInstance("byd", 10, "red");
//        System.out.println(car1);

//        构造private
        Constructor c2 = class1.getDeclaredConstructor(String.class, int.class, String.class);
        c2.setAccessible(true); //允许访问私有
        Car car2 = (Car) c2.newInstance("byd", 15, "red");
        System.out.println(car2);
    }


//    获取属性
    @Test
    public void test03() throws Exception {
        Class class1 = Car.class;
    }

}
