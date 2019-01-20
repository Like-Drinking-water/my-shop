package com.huanleichen.my.shop.service;

import com.huanleichen.my.shop.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface LoginService {
    /**
     * 登录操作
     * @param email 登录所需的邮箱
     * @param password 登录所需的密码
     * @return 登录成功放回登录信息，失败返回null
     */
    public User login(String email, String password);

}
