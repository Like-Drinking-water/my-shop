package com.huanleichen.my.shop.service.impl;

import com.huanleichen.my.shop.commons.utils.SpringContext;
import com.huanleichen.my.shop.dao.UserDao;
import com.huanleichen.my.shop.entity.User;
import com.huanleichen.my.shop.service.LoginService;

public class LoginServiceImpl implements LoginService {

    public User login(String email, String password) {
        SpringContext context = new SpringContext();
        UserDao dao = (UserDao) context.getBean("UserDao");
        User user = dao.getUserByEmailAndPassword(email, password);
        return user;
    }
}
