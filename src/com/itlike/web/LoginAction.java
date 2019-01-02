package com.itlike.web;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import domain.User;

public class LoginAction extends ActionSupport implements ModelDriven<User>{
    private User user = new User();
    @Override
    public User getModel() {
        return user;
    }
    public String login(){
        System.out.println("login来了");
        System.out.println(user);
        return null;
    }


}
