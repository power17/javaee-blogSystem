package com.itlike.web.dao;

import com.itlike.web.domain.Category;

import java.util.List;

public interface CategoryDao {
    public void save(Category category);

    List<Category> getAllCategory();
    //根据id查询
    Category getOneCategory(Integer cid);

    void update(Category category);
}
