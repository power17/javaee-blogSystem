package com.itlike.web.service.impl;

import com.itlike.web.dao.UserDao;
import com.itlike.web.service.LoginService;
import com.itlike.web.domain.User;

public class LoginServiceImpl implements LoginService {
    private UserDao userDao;
    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }
    @Override
    public void login(User user) {
        System.out.println("用户名" + user.getUsername());
        //调用dao查询用户
        userDao.getUser(user.getUsername(),user.getPassword());
    }
}
