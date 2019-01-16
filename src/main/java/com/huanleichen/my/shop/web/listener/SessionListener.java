package com.huanleichen.my.shop.web.listener;

import com.huanleichen.my.shop.web.utils.MySession;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {
    MySession sessionMap = MySession.getInstance();

    public void sessionCreated(HttpSessionEvent se) {
        sessionMap.addSession(se.getSession());
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        sessionMap.delSession(se.getSession());
    }
}
