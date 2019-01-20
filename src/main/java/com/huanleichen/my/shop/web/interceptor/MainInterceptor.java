package com.huanleichen.my.shop.web.interceptor;

import com.huanleichen.my.shop.commons.contants.ContantsUtils;
import com.huanleichen.my.shop.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute(ContantsUtils.SESSION_NAME);

        //用户已登录
        if (user != null) {
            return true;
        }
        //用户未登录
        else {
            //重定向到登录页面
            response.sendRedirect("login");
            return false;
        }
    }

}
