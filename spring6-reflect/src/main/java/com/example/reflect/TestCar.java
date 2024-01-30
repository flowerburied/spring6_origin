package com.example.reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

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
        Class clazz = Car.class;
        Car car = (Car) clazz.getDeclaredConstructor().newInstance();

        //获取所有public属性
        Field[] fields = clazz.getFields();
        //获取所有属性（包括private私有属性）
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (declaredField.getName().equals("name")) {
                //设置允许访问
                declaredField.setAccessible(true);
                declaredField.set(car, "byd");
            }

            System.out.println(declaredField.getName());
            System.out.println(car);
        }
    }


    //获取方法
    @Test
    public void test04() throws Exception {

        Car car = new Car("byd", 10, "red");
        Class clazz = car.getClass();

//        public方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
//            System.out.println(method.getName());
            //执行方法 toString
            if (method.getName().equals("toString")) {
                String invoke = (String) method.invoke(car);
                System.out.println("toString method execute" + invoke);
            }

        }


//        private方法
        Method[] methodsAll = clazz.getDeclaredMethods();
        for (Method method : methodsAll) {
//            System.out.println(method.getName());
            //执行方法 run
            if (method.getName().equals("run")) {
                method.setAccessible(true);
                method.invoke(car);

            }

        }
    }

}
