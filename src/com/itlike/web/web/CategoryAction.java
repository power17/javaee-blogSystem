package com.itlike.web.web;

import com.itlike.web.domain.Category;
import com.itlike.web.service.CategoryService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import lombok.Setter;

import java.util.List;

public class CategoryAction extends ActionSupport implements ModelDriven<Category> {
    private Category category = new Category();
    @Override
    public Category getModel() {

        return category;
    }
    @Setter
    private CategoryService categoryService;
    public String add(){
        System.out.println("categoryAction");
        categoryService.save(category);
        return null;
    }
    public String list(){
        System.out.println("listAction");
        List<Category> list = categoryService.getAllCategory();
        System.out.println(list);
        return null;
    }
}
