package com.itlike.web.dao.impl;

import com.itlike.web.dao.CategoryDao;
import com.itlike.web.domain.Category;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.io.Serializable;
import java.util.List;


public class CategoryDaoImpl extends HibernateDaoSupport implements CategoryDao {
    @Override
    //保存列表
    public void save(Category category) {
        System.out.println("categoryDao~~~~" + this.getHibernateTemplate());
        this.getHibernateTemplate().save(category);
    }

    @Override
    public List<Category> getAllCategory() {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Category.class);
        List<Category> list =(List<Category>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
        return list;
    }
}
