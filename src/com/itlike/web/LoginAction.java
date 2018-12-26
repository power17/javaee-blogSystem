package com.itlike.web;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

    public String login(){
        System.out.println("login来了");
        return null;
    }
}
