package com.itlike.web.dao.impl;

import com.itlike.web.dao.ArticleDao;
import com.itlike.web.domain.Article;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public class ArticleDaoImpl extends HibernateDaoSupport implements ArticleDao {

    @Override
    public List<Article> getAllArticle( ) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Article.class);
        List<Article> list = (List<Article>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
        return list;
    }
    @Override
    public Integer getTotalCount(DetachedCriteria detachedCriteria) {
        //查询总记录
        detachedCriteria.setProjection(Projections.rowCount());
        List<Long> list = (List<Long>)this.getHibernateTemplate().findByCriteria(detachedCriteria);
        if(list.size() > 0){
            return list.get(0).intValue();
        }
        return 0;
    }

    @Override
    public List<Article> getPageData(DetachedCriteria detachedCriteria, Integer index, Integer
            pageSize) {

        //清空查询总记录条件
        detachedCriteria.setProjection(null);
        List<Article> list = (List<Article>)this.getHibernateTemplate().findByCriteria
                (detachedCriteria,
                        index,
                        pageSize);
        return list;

    }

    @Override
    public void delete(Article article) {
        this.getHibernateTemplate().delete(article);
    }


}
