package com.itlike.web;

import com.itlike.web.domain.User;
import com.itlike.web.service.LoginService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


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
        User resUser = loginService.login(user);
        System.out.println(resUser +"~~~");
        if(resUser == null){
            this.addActionError("用户名或密码错误");
            return LOGIN;
        }else{
            //保存用户信息
            ActionContext.getContext().getSession().put("curUser",resUser);
            System.out.println("nin16516");
            return SUCCESS;
        }
    }


}
