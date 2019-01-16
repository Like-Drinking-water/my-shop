package com.huanleichen.my.shop.service;

import com.huanleichen.my.shop.entity.User;

public interface LoginService {
    public User login(String email, String password);
}
