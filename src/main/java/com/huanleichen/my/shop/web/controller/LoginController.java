package com.huanleichen.my.shop.web.controller;

import com.huanleichen.my.shop.entity.User;
import com.huanleichen.my.shop.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {
    @Autowired
    LoginService loginService;

    @RequestMapping(value = {"", "login"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam(required = true) String email, @RequestParam(required = true) String password) {
        User user = loginService.login(email, password);

        //登录成功
        if (user != null) {
            return "redirect:/main";
        }

        //登录失败
        else {
            return login();
        }

    }
}
