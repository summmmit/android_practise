package com.jetnix.my.schoolopaediaapp;

public class Users {

    String email, password_again, password;
    int age;

    public Users(String email, String password, String password_again) {
        this.email = email;
        this.password_again = password_again;
        this.password = password;
    }

    public Users(String email, String password) {
        this("", email, password);
    }
}
