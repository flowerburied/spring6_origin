package com.example.spring6.resourceloader;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;

public class FileSystemResourceDemo {
    @Test
    public void demo1() {
        ApplicationContext context = new ClassPathXmlApplicationContext();
        Resource resource = context.getResource("example.txt");
        System.out.println(resource.getFilename());
    }

    @Test
    public void demo2() {
        ApplicationContext context = new FileSystemXmlApplicationContext();
        Resource resource = context.getResource("example.txt");
        System.out.println(resource.getFilename());
    }
}
