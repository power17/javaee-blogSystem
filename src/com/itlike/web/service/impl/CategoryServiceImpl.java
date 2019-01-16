package com.itlike.web.service.impl;

import com.itlike.web.dao.CategoryDao;
import com.itlike.web.domain.Category;
import com.itlike.web.service.CategoryService;
import com.opensymphony.xwork2.ActionContext;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class CategoryServiceImpl implements CategoryService {
    @Setter
    private CategoryDao categoryDao;
    //新增分类
    @Override
    public void save(Category category) {
        System.out.println("调用service~category");
        /*调用业务层*/
        categoryDao.save(category);
    }
    //查询分类
    @Override
    public List<Category> getAllCategory() {

        //调用dao层查询所有分类
       List<Category> list = categoryDao.getAllCategory();
       return list;
    }

    @Override
    public Category getOneCategory(Integer cid) {
        //调用dao层
        Category category = categoryDao.getOneCategory(cid);

        return category;
    }
}
