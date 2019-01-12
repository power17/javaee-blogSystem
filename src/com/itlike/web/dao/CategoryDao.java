package com.itlike.web.dao;

import com.itlike.web.domain.Category;

import java.util.List;

public interface CategoryDao {
    public void save(Category category);

    List<Category> getAllCategory();
}
