package com.itlike.web.web;

import com.itlike.web.domain.Category;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CategoryAction extends ActionSupport implements ModelDriven<Category> {
    private Category category = new Category();
    @Override
    public Category getModel() {

        return category;
    }
    public String add(){
        System.out.println(category);
        return null;
    }
}
