package com.itlike.web.dao;

import com.itlike.web.domain.Article;
import com.itlike.web.domain.Category;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface ArticleDao {
    List<Article>getAllArticle();
    //获取总记录数
    Integer getTotalCount(DetachedCriteria detachedCriteria);

    //查询分页的数据
    List<Article> getPageData(DetachedCriteria detachedCriteria, Integer index, Integer pageSize);

    void delete(Article article);

    List<Category> getCategory(Integer parentid);

    void save(Article article);

    Article getOneArticle(Integer article_id);

    void update(Article article);

}
