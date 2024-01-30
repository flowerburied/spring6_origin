package com.example.spring6;

public class User {

    //    无参构造
    public User() {
        System.out.println(" 无参构造..");
    }

    public void add() {
        System.out.println("add..");
    }
    public static void main(String[] args) {
        User user = new User();
        user.add();
    }
}
