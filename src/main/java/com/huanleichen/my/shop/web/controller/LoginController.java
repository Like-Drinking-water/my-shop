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
        //String remember = req.getParameter("remember");
        //String autoLogin = req.getParameter("auto-login");

        //System.out.println(remember);
        //System.out.println(autoLogin);

        User user = loginService.login(email, passsword);

        //登录成功
        if (user != null) {
            resp.sendRedirect("index.jsp");
            String name = "Login";
            String value =  session.getId();
            session.setAttribute("login", user);
            Cookie cookie = new Cookie(name, value);
            resp.addCookie(cookie);
        }

        //登录失败
        else {
            req.setAttribute("message", "密码或邮箱错误");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
