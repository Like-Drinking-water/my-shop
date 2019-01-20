package com.huanleichen.my.shop.web.interceptor;

import com.huanleichen.my.shop.commons.contants.ContantsUtils;
import com.huanleichen.my.shop.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        User user = (User) request.getSession().getAttribute(ContantsUtils.SESSION_NAME);

        //如果用户已登录
        if (user != null) {
            //重定向到主页
            response.sendRedirect("main");
        }
    }
}
