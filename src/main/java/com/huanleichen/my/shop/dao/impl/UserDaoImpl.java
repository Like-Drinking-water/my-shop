package com.huanleichen.my.shop.dao.impl;

import com.huanleichen.my.shop.dao.UserDao;
import com.huanleichen.my.shop.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository(value = "UserDao")
public class UserDaoImpl implements UserDao {
    private static Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    public User getUserByEmailAndPassword(String email, String password) {
        User user = null;

        if (email.equals("admin@huanleichen.com")) {
            if (password.equals("admin")) {
                user = new User("admin@huanleichen.com", "admin", "admin");
                logger.info("登录成功");
            }
        }

        return user;
    }
}
