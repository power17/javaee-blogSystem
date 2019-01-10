package com.itlike.web.dao;

import com.itlike.web.domain.User;

public interface UserDao {
    public User getUser(String username, String password);
}
