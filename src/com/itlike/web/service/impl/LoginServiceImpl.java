package com.itlike.web.service.impl;

import com.itlike.web.dao.UserDao;
import com.itlike.web.service.LoginService;
import com.itlike.web.domain.User;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class LoginServiceImpl implements LoginService {
    private UserDao userDao;
    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }
    @Override
    public User login(User user) {
        System.out.println("用户名" + user.getUsername());
        //调用dao查询用户
        return userDao.getUser(user.getUsername(),user.getPassword());

    }
}
