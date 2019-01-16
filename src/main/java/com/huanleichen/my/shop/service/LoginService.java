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

    /**
     * 成功登录后，登录操作没有记住密码和自动登录
     * @param user 登录成功获取到的用户信息
     */
    public void onlyLogin(User user, HttpServletRequest request, HttpServletResponse response) throws IOException;

    /**
     *  成功登录后，登录并记住密码
     * @param user 登录成功获取到的用户信息
     */
    public void LoginAndRemember(User user, HttpServletRequest request, HttpServletResponse response) throws IOException;

    /**
     * 成功登录后，登录记住密码并自动登录
     * @param user 登录成功获取到的用户信息
     */
    public void LoginRememberAndAutoLogin(User user, HttpServletRequest request, HttpServletResponse response) throws IOException;
}
