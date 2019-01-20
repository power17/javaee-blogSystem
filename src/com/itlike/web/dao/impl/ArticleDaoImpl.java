package com.itlike.web.dao.impl;

import com.itlike.web.dao.ArticleDao;
import com.itlike.web.domain.Article;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class ArticleDaoImpl extends HibernateDaoSupport implements ArticleDao {

    @Override
    public List<Article> getAllArticle( ) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Article.class);
        List<Article> list = (List<Article>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
        return list;
    }
}
