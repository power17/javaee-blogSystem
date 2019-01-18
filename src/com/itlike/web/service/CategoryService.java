package com.itlike.web.service;

import com.itlike.web.domain.Category;

import java.util.List;

public interface CategoryService {
    public void save (Category category);

    List<Category> getAllCategory();

    Category getOneCategory(Integer cid);
   /*修改分页*/
    void update(Category category);
    /*删除分类*/
    void delete(Category category);
}
