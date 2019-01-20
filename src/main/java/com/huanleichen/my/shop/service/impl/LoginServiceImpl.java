package com.huanleichen.my.shop.service.impl;

import com.huanleichen.my.shop.commons.utils.SpringContext;
import com.huanleichen.my.shop.dao.UserDao;
import com.huanleichen.my.shop.entity.User;
import com.huanleichen.my.shop.service.LoginService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Service(value = "LoginService")
public class LoginServiceImpl implements LoginService {

    public User login(String email, String password) {
        UserDao dao = SpringContext.getBean("UserDao");
        User user = dao.getUserByEmailAndPassword(email, password);
        return user;
    }

}
