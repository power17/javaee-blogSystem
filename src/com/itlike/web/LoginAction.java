package com.itlike.web;

import com.itlike.web.service.LoginService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import domain.User;

public class LoginAction extends ActionSupport implements ModelDriven<User>{
    private User user = new User();
    @Override
    public User getModel() {
        return user;
    }

    //注入业务层
    private LoginService loginService;
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }


    public String login(){
        System.out.println("login来了");
        System.out.println(user);
        loginService.login(user);
        return null;

    }


}
