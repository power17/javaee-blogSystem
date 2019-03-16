package com.itlike.web.service;

import com.itlike.web.domain.Article;
import com.itlike.web.domain.Category;
import com.itlike.web.domain.PageBean;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface ArticleService {
//    查询所有文章列表
    List<Article>getAllArticle();

    PageBean getPageData(DetachedCriteria detachedCriteria, Integer currPage, int i);



    void delete(Article article);
    //获取目录
    List<Category> getCategory(Integer parentid);

    void save(Article article );

    Article getOneArticle(Integer article_id);

    void update(Article article);

}

