package com.huanleichen.my.shop.web.controller;

import com.huanleichen.my.shop.entity.User;
import com.huanleichen.my.shop.web.utils.MySession;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginPageController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        MySession sessionMap = MySession.getInstance();
        if (cookies != null && cookies.length != 0) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("auto-login")) {
                    HttpSession session = sessionMap.getSession(cookies[i].getValue());
                    //保存用户信息的session存在
                    if (session != null) {
                        User user = (User) session.getAttribute("login");
                        req.setAttribute("login", user);
                        req.getRequestDispatcher("WEB-INF/index.jsp").forward(req, resp);
                    }
                    //保存用户信息的session不存在
                    else {
                        break;
                    }
                }
            }

            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("login")) {
                    //获取保存用户信息的session
                    HttpSession session = sessionMap.getSession(cookies[i].getValue());

                    //如果登录信息还有效
                    if (session != null) {
                        req.setAttribute("login", session.getAttribute("login"));
                        req.getRequestDispatcher("WEB-INF/index.jsp").forward(req, resp);
                    } else {
                        break;
                    }
                }
            }

            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("email") || cookies[i].getName().equals("password")) {
                    req.setAttribute(cookies[i].getName(), cookies[i].getValue());
                }
            }
        }

        req.getRequestDispatcher("WEB-INF/login.jsp").forward(req, resp);

    }
}
