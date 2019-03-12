package com.itlike.web.web;

import com.itlike.web.domain.Article;
import com.itlike.web.domain.Category;
import com.itlike.web.domain.PageBean;
import com.itlike.web.service.ArticleService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import lombok.Setter;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.aspectj.util.FileUtil;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class ArticleAction extends ActionSupport implements ModelDriven<Article> {
    private Article article = new Article();
    @Override
    public Article getModel( ) {
        return article;
    }
    //注入
    @Setter
    private ArticleService articleService;
    public  String list() {
        //调用业务层
        List<Article> allArticle = articleService.getAllArticle();
        System.out.println(allArticle);
        //把数据存在值栈中
        ActionContext.getContext().getValueStack().set("allActicle",allArticle);
        return "list";
    }

    /*获取分页数据*/
    @Setter
    private Integer currPage = 1;
    @Setter
    //搜索关键字
    private String keyWord;
    public String pageList(){
        System.out.println(currPage);
        System.out.println(keyWord);
        //离线查询条件()
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Article.class);
        //设置条件
        if(keyWord != null){
            //添加条件
            detachedCriteria.add(Restrictions.like("article_title","%"+keyWord+"%"));
        }
        //调用业务层
        PageBean pageBean =articleService.getPageData(detachedCriteria,currPage,5);
        //数据存入值栈中
        ActionContext.getContext().getValueStack().push(pageBean);
        return "list";
    }

    //删除功能
    public String delete(){
        Article article2 = new Article();
        article2.setArticle_id(article2.getArticle_id());
        articleService.delete(article2);
        System.out.println(article2.getArticle_id());


        return "listres";
    }

    //获取目录
    @Setter
    private Integer parentid;
    public String getCategory() throws IOException {
//        System.out.println(parentid);
        List<Category> list =articleService.getCategory(parentid);
        System.out.println(list);
        //以json传回浏览器
        JSONArray jsonArray = JSONArray.fromObject(list,new JsonConfig());
        System.out.println(jsonArray);
        //响应给页面
        ServletActionContext.getResponse().setContentType("text/html:charset=UTF-8");
        ServletActionContext.getResponse().getWriter().println(jsonArray.toString());
        return null;
    }


    //添加文章
    @Setter
    private String uploadFileName;
    @Setter
    private File upload;
    @Setter
    private String uploadContentType;

    public String add() throws IOException {
       if(upload != null){

           //随机文件名
           int idx = uploadFileName.lastIndexOf(".");
           String extions = uploadFileName.substring(idx);
           //防止文件重命名
           String uuidFileName = UUID.randomUUID().toString().replace("-","") + extions;
           System.out.println(uuidFileName);
           //设置文件上传路径
           String path = ServletActionContext.getServletContext().getRealPath("/upload");
           File file = new File(path);
           if(!file.exists()){
               file.mkdirs();
           }

           //文件上传
           File dictFile = new File(path + "/" +uuidFileName);
           FileUtils.copyFile(upload,dictFile);
           //设置图片
           article.setArticle_pic(uuidFileName);

       }
       //设置当前时间
        article.setArticle_time((int) new Date().getTime());

       //保存到数据库中
        articleService.save(article);



        return "listres";
    }
    public String edit(){
        //从数据库中获取当前文章
        Article resArticle = articleService.getOneArticle(article.getArticle_id());
        System.out.println(resArticle);
        //把查询的数据存放在值栈中
        ActionContext.getContext().getValueStack().push(resArticle);
        return "edit";



    }


}


