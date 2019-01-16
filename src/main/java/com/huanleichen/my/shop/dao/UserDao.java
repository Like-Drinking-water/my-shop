package com.huanleichen.my.shop.dao;

import com.huanleichen.my.shop.entity.User;

public interface UserDao {
    public User getUserByEmailAndPassword(String email, String password);
}
