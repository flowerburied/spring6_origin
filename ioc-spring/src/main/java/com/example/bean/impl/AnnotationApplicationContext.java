package com.example.bean.impl;

import com.example.anno.Bean;
import com.example.anno.Di;
import com.example.bean.ApplicationContext;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AnnotationApplicationContext implements ApplicationContext {

    //创建map聚合，放bean对象
    private Map<Class, Object> beanFactory = new HashMap<>();

    private static String rootPath;

    //返回对象
    @Override
    public Object getBean(Class clazz) {
        return beanFactory.get(clazz);
    }


    //创建有参数构造，传递包路径，设置包扫描规则
    //当前包及其子包，哪个类有@Bean注解，把这个类通过反射实例化
    public AnnotationApplicationContext(String basePackage) {
//    public static void pathDemo1(String basePackage) {
        try {
            //把.换成\\
            String packagePath = basePackage.replaceAll("\\.", "\\\\");
//            System.out.println("packagePath===" + packagePath);
            //获取包的绝对路径
            Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(packagePath);
//            System.out.println("urls===" + urls);
            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
                String filePath = URLDecoder.decode(url.getFile(), "utf-8");

                System.out.println("filePath===" + filePath);
                //获取包前置路径，字符串的截取
                rootPath = filePath.substring(0, filePath.length() - packagePath.length());

                //包扫描
                loadBean(new File(filePath));

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //属性注入
        loadDi();


    }


    //包扫描的过程，构建实例化
    private void loadBean(File file) throws Exception {

        //判断是否为文件夹
        if (file.isDirectory()) {
            //获取文件夹中所有内容
            File[] childrenFiles = file.listFiles();

            //判断文件夹是否为空，空直接返回
            if (childrenFiles == null || childrenFiles.length == 0) {
                return;
            }
            //不为空,遍历文件夹所有内容
            for (File child : childrenFiles) {
//                System.out.println("child.isDirectory()===" + child.isDirectory());
                //继续判断是否为文件夹，递归
                if (child.isDirectory()) {
                    loadBean(child);
                } else {
                    //得到文件，获取包路径+类名称部分 - 字符串截取
                    String pathWithClass = child.getAbsolutePath().substring(rootPath.length() - 1);
//                    System.out.println("pathWithClass===" + pathWithClass);

                    //判断文件类型是否为.class

                    if (pathWithClass.contains(".class")) {

                        //把路径\替换成.   把.class去掉
                        String allName = pathWithClass
                                .replaceAll("\\\\", ".")
                                .replace(".class", "");
                        System.out.println("allName===" + allName);

                        //判断类上是否有注解 @Bean ,如果有，实例化过程
                        //获取类的class
                        Class<?> clazz = Class.forName(allName);
                        //判断是否为接口
                        if (!clazz.isInterface()) {
                            //判断是否有@Bean注解
                            Bean annotation = clazz.getAnnotation(Bean.class);
                            if (annotation != null) {
                                //实例化
                                Object instance = clazz.getConstructor().newInstance();
                                //把实例化的对象，放到map聚合beanFactory
                                //判断当前类如果有接口，让接口class作为map的key
                                if (clazz.getInterfaces().length > 0) {
                                    beanFactory.put(clazz.getInterfaces()[0], instance);

                                } else {
                                    beanFactory.put(clazz, instance);
                                }

                            }

                        }
                    }

                }
            }
        }
    }

    //属性注入
    private void loadDi() {
        //实例化对象都在beanFactory的map集合里
        Set<Map.Entry<Class, Object>> entries = beanFactory.entrySet();

        for (Map.Entry<Class, Object> entry : entries) {
            //获取map集合的每个对象
            Object obj = entry.getValue();
            //获取对象class
            Class<?> clazz = obj.getClass();
            //获取每个对象的属性
            Field[] declaredFields = clazz.getDeclaredFields();

            for (Field field : declaredFields) {
                //判断属性上是否有@Di注解
                Di annotation = field.getAnnotation(Di.class);
                if (annotation != null) {
                    //如果是私有属性，设置可以设置
                    field.setAccessible(true);
                    //对象进行注入
                    try {
                        field.set(obj, beanFactory.get(field.getType()));
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }

                }

            }

        }


    }
//    public static void main(String[] args) {
//        AnnotationApplicationContext context = new AnnotationApplicationContext("com.example");
//        context.getBean()
//    }

}
