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

    public void onlyLogin(User user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String name = "login";
        String value =  session.getId();
        //在session中保存用户的信息
        session.setAttribute(name, user);
        //将sessionId放到value中
        Cookie cookie = new Cookie(name, value);
        //设置cookie的有效路径
        cookie.setPath(request.getContextPath());
        response.addCookie(cookie);
        //跳转到首页
        response.sendRedirect("index.html");
    }

    public void LoginAndRemember(User user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie cookieEmail = new Cookie("email", user.getEmail());
        Cookie cookiePassword = new Cookie("password", user.getPassword());
        //设置有效路径
        cookieEmail.setPath(request.getContextPath());
        cookiePassword.setPath(request.getContextPath());
        //设置Cookie有效时间
        cookieEmail.setMaxAge(Integer.MAX_VALUE);
        cookiePassword.setMaxAge(Integer.MAX_VALUE);
        //添加Cookie
        response.addCookie(cookieEmail);
        response.addCookie(cookiePassword);
        this.onlyLogin(user, request, response);
    }

    public void LoginRememberAndAutoLogin(User user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(Integer.MAX_VALUE);
        Cookie cookie = new Cookie("auto-login", session.getId());
        //设置有效路径
        cookie.setPath(request.getContextPath());

        //设置有效时间
        cookie.setMaxAge(Integer.MAX_VALUE);

        //添加Cookie
        response.addCookie(cookie);


        this.LoginAndRemember(user, request, response);
    }
}
