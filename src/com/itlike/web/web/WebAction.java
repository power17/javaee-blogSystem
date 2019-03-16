package com.itlike.web.web;

import com.itlike.web.domain.Article;
import com.itlike.web.domain.PageBean;
import com.itlike.web.service.ArticleService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import lombok.Setter;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.io.IOException;

public class WebAction extends ActionSupport {
    //注入
    @Setter
    private ArticleService articleService;
    @Setter
    private Integer currPage = 1;
    public void  getPageList() throws IOException {

        //离线查询条件()
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Article.class);
        //设置条件

        //调用业务层
        PageBean pageBean =articleService.getPageData(detachedCriteria,currPage,5);
        //以json传回浏览器
        JsonConfig jsonConfig = new JsonConfig();
        //懒加载（因为关联对象）
        jsonConfig.setExcludes(new String[]{"handler","hibernateLazyInitializer"});
        JSONObject jsonObject = JSONObject.fromObject(pageBean,jsonConfig);
        System.out.println(jsonObject);
        //响应给页面
        ServletActionContext.getResponse().setContentType("text/html:charset=UTF-8");
        ServletActionContext.getResponse().getWriter().println(jsonObject.toString());


    }

}
