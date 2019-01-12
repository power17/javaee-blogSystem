package com.itlike.web.dao.impl;

import com.itlike.web.dao.UserDao;
import com.itlike.web.domain.User;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;


import java.util.List;

public class UserDaoimpl extends HibernateDaoSupport implements UserDao {
    @Override
    public User getUser(String username, String password) {
        System.out.println("dao" + username + password);
        //到数据库去查询
        //设置到哪个表去查
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User.class);
        //设置条件
        detachedCriteria.add(Restrictions.eq("username",username));
        detachedCriteria.add(Restrictions.eq("password",password));

        //找出来放在user对象
        List<User> list = (List<User>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
        if(list.size()>0){
            return list.get(0);
        }
        return null;

    }
}
