package com.example.bean.impl;

import com.example.bean.ApplicationContext;

import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class AnnotationApplicationContext implements ApplicationContext {

    //创建map聚合，放bean对象
    private Map<Class, Object> beanFactory = new HashMap<>();

    //返回对象
    @Override
    public Object getBean(Class clazz) {
        return beanFactory.get(clazz);
    }


    //创建有参数构造，传递包路径，设置包扫描规则
    //当前包及其子包，哪个类有@Bean注解，把这个类通过反射实例化
//    public AnnotationApplicationContext(String basePackage) {
    public static void pathDemo1(String basePackage) {
        try {
            //把.换成\\
            String packagePath = basePackage.replaceAll("\\.", "\\\\");
            System.out.println("packagePath===" + packagePath);
            //获取包的绝对路径
            Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(packagePath);
            System.out.println("urls===" + urls);
            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
                String filePath = URLDecoder.decode(url.getFile(), "utf-8");

                System.out.println("filePath===" + filePath);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static void main(String[] args) {
        pathDemo1("com.example");
    }


//    public static void main(String[] args) {
//        AnnotationApplicationContext context = new AnnotationApplicationContext("com.example");
//        context.getBean()
//    }

}
