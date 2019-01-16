package com.huanleichen.my.shop.web.utils;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

public class MySession {
    private static MySession instance;
    private HashMap<String, HttpSession> sessionMap;

    public MySession() {
        sessionMap = new HashMap<String, HttpSession>();
    }

    public static MySession getInstance() {
        //如果不存在MySession对象，则创建一个
        if (instance == null) {
            instance = new MySession();
        }

        return instance;
    }

    public void delSession(HttpSession session) {
        if (session != null) {
            sessionMap.remove(session.getId());
        }
    }

    public void addSession(HttpSession session) {
        if (session != null) {
            sessionMap.put(session.getId(), session);
        }
    }

    public HttpSession getSession(String sessionId) {
        if (sessionId == null) {
            return null;
        }
        else {
            return sessionMap.get(sessionId);
        }
    }
}
