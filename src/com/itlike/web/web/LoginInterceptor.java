package com.itlike.web.web;

import com.itlike.web.domain.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;

public class LoginInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        //判断用户是否登录
        User user = (User) ServletActionContext.getRequest().getSession().getAttribute("curUser");
        if(user == null){
            //没有登录，跳转登录
             ActionSupport action= (ActionSupport) actionInvocation.getAction();
             action.addActionError("你还没有登录，没有权限访问");
            return "login";
        }else{
            return actionInvocation.invoke();

        }
    }
}
