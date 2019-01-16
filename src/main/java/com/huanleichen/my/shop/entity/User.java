package com.huanleichen.my.shop.entity;

import java.io.Serializable;

public class User implements Serializable {
    private String email;
    private String password;
    private String userName;

    public User() {
    }

    public User(String email, String password, String userName) {
        this.email = email;
        this.password = password;
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
