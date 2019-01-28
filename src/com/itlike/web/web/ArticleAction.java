package com.itlike.web.web;

import com.itlike.web.domain.Article;
import com.itlike.web.domain.PageBean;
import com.itlike.web.service.ArticleService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import lombok.Setter;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

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
    @Setter
    //搜索关键字
    private String keyWord;
    public String pageList(){
        System.out.println(currPage);
        System.out.println(keyWord);
        //离线查询条件()
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Article.class);
        //设置条件
        if(keyWord != null){
            //添加条件
            detachedCriteria.add(Restrictions.like("article_title","%"+keyWord+"%"));
        }
        //调用业务层
        PageBean pageBean =articleService.getPageData(detachedCriteria,currPage,5);
        //数据存入值栈中
        ActionContext.getContext().getValueStack().push(pageBean);
        return "list";
    }

    //删除功能
    @Setter
    private Integer article_id;
    public String delete(){
        Article article = new Article();
        article.setArticle_id(article_id);
        articleService.delete(article);

        return "delete";
    }

}


