package com.itlike.web.web;

import com.itlike.web.domain.Category;
import com.itlike.web.service.CategoryService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import lombok.Setter;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.apache.struts2.ServletActionContext;

import java.io.IOException;
import java.util.List;

public class CategoryAction extends ActionSupport implements ModelDriven<Category> {
    private Category category = new Category();
    @Override
    public Category getModel() {

        return category;
    }
    //注入service
    @Setter
    private CategoryService categoryService;

    //分类管理新增接口
    public String add(){
        System.out.println("categoryAction");
        categoryService.save(category);
        return null;
    }
    //分类管理列表接口
    public String list(){

        System.out.println("listAction");
        List<Category> list = categoryService.getAllCategory();
        //把数据存在值栈中
        ActionContext.getContext().getValueStack().set("categorylist",list);
        return "list";
    }

    public String updateUI() throws IOException {
        System.out.println("updateUIAction");
        System.out.println(category.getCid());
        //调用业务层
        Category category2 = categoryService.getOneCategory(category.getCid());
        //把数据响应给页面
        System.out.println(category2);
        //以json传回浏览器
        JSONArray jsonArray = JSONArray.fromObject(category2,new JsonConfig());
        System.out.println(jsonArray);
        //响应给页面
        ServletActionContext.getResponse().setContentType("text/html:charset=UTF-8");
        ServletActionContext.getResponse().getWriter().println(jsonArray.toString());


        return null;
    }

    public String update(){
        System.out.println("update~~~");
        //调用业务层
        categoryService.update(category);
        return "listAction";
    }

}
