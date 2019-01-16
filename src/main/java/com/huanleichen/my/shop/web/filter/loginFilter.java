package com.huanleichen.my.shop.web.filter;

import com.huanleichen.my.shop.web.utils.MySession;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class loginFilter implements Filter {
    MySession sessionMap = MySession.getInstance();

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        Cookie[] cookies = request.getCookies();

        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals("login")) {
                if (sessionMap.getSession(String.valueOf(cookies[i].getValue())) != null) {
                    filterChain.doFilter(request, response);
                }
            }
        }
    }

    public void destroy() {

    }
}
