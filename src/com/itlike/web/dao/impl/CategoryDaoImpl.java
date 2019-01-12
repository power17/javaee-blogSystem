package com.itlike.web.dao.impl;

import com.itlike.web.dao.CategoryDao;
import com.itlike.web.domain.Category;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.io.Serializable;


public class CategoryDaoImpl extends HibernateDaoSupport implements CategoryDao {
    @Override
    public void save(Category category) {
        System.out.println("categoryDao~~~~" + this.getHibernateTemplate());
        this.getHibernateTemplate().save(category);
    }
}
