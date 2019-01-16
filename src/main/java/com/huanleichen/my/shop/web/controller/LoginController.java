package com.huanleichen.my.shop.web.controller;

import com.huanleichen.my.shop.commons.utils.SpringContext;
import com.huanleichen.my.shop.entity.User;
import com.huanleichen.my.shop.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginController extends HttpServlet  {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SpringContext context = new SpringContext();
        LoginService loginService = (LoginService) context.getBean("LoginService");
        HttpSession session = req.getSession();

        String email = req.getParameter("email");
        String passsword = req.getParameter("password");

        String remember = req.getParameter("remember");
        String autoLogin = req.getParameter("auto-login");

        User user = loginService.login(email, passsword);

        //登录成功
        if (user != null && remember == null && autoLogin == null) {
            loginService.onlyLogin(user, req, resp);
        }

        else if (user != null && remember != null && autoLogin == null) {
           loginService.LoginAndRemember(user, req, resp);
        }

        else if (user != null && autoLogin != null) {
            loginService.LoginRememberAndAutoLogin(user, req, resp);
        }

        //登录失败
        else {
            req.setAttribute("message", "密码或邮箱错误");
            req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
        }
    }
}
