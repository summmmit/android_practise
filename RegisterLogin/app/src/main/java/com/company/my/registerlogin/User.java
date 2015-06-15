package com.company.my.registerlogin;

/**
 * Created by 1084760 on 2015/06/15.
 */
public class User {
    String name, username, password;
    Integer age;

    public User(String name, Integer age, String username, String password){
        this.name = name;
        this.age  = age;
        this.username = username;
        this.password = password;
    }

    public User(String username, String password){
        this("", -1, username, password);
    }
}
