package com.itlike.web.dao.impl;

import com.itlike.web.dao.UserDao;
import domain.User;

public class UserDaoimpl implements UserDao {
    @Override
    public User getUser(String username, String password) {
        System.out.println("dao" + username + password);
        return null;
    }
}
