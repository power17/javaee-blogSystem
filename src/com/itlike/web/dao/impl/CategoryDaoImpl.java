package com.itlike.web.dao.impl;

import com.itlike.web.dao.CategoryDao;
import com.itlike.web.domain.Category;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
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

    @Override
    public Category getOneCategory(Integer cid) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Category.class);
        //设置条件
        detachedCriteria.add(Restrictions.eq("cid",cid));

        List<Category> list = ( List<Category>)this.getHibernateTemplate().findByCriteria(detachedCriteria);
        if(list.size()>0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public void update(Category category) {
        System.out.println(category);
        this.getHibernateTemplate().update(category);
    }

    @Override
    public void delete(Category category) {
        this.getHibernateTemplate().delete(category);
    }
}
