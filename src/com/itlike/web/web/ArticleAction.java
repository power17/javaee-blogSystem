package com.itlike.web.web;

import com.itlike.web.domain.Article;
import com.itlike.web.domain.PageBean;
import com.itlike.web.service.ArticleService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import lombok.Setter;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public class ArticleAction extends ActionSupport {
    //注入
    @Setter
    private ArticleService articleService;
    public  String list() {
        //调用业务层
        List<Article> allArticle = articleService.getAllArticle();
        System.out.println(allArticle);
        //把数据存在值栈中
        ActionContext.getContext().getValueStack().set("allActicle",allArticle);
        return "list";
    }

    /*获取分页数据*/
    @Setter
    private Integer currPage = 1;
    public String pageList(){
        System.out.println(currPage);
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Article.class);
        //调用业务层
        PageBean pageBean =articleService.getPageData(detachedCriteria,currPage,5);
        //数据存入值栈中
        ActionContext.getContext().getValueStack().push(pageBean);
        return "list";
    }

}


