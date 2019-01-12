package com.itlike.web.service.impl;

import com.itlike.web.dao.CategoryDao;
import com.itlike.web.domain.Category;
import com.itlike.web.service.CategoryService;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class CategoryServiceImpl implements CategoryService {
    @Setter
    private CategoryDao categoryDao;

    @Override
    public void save(Category category) {
        System.out.println("调用service~category");
        /*调用业务层*/
        categoryDao.save(category);


    }
}
