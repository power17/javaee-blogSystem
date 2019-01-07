package com.itlike.web.dao;

import domain.User;

public interface UserDao {
    public User getUser(String username, String password);
}
