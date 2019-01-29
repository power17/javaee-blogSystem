package com.itlike.web.service.impl;

import com.itlike.web.dao.ArticleDao;
import com.itlike.web.domain.Article;
import com.itlike.web.domain.Category;
import com.itlike.web.domain.PageBean;
import com.itlike.web.service.ArticleService;
import lombok.Setter;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public class ArticleServiceImpl implements ArticleService {
    @Setter
    private ArticleDao articleDao;
    @Override
    public List<Article> getAllArticle( ) {
        List<Article> allArticle = articleDao.getAllArticle();
        return allArticle;
    }

    @Override
    public PageBean getPageData(DetachedCriteria detachedCriteria, Integer currPage, int pageSize) {
        PageBean<Article> pageBean = new PageBean<>();
        //设置当前页
        pageBean.setCurrentPage(currPage);
        //设置当前一页有多少数据
        pageBean.setPageSize(pageSize);
        //获取总记录数
        //从数据库当中查询总记录数
        Integer totalCount = articleDao.getTotalCount(detachedCriteria);

        pageBean.setTotalCount(totalCount);
        //设置总页数
        pageBean.setTotalPage(pageBean.getTotalPage());
        //查询数据库
        List<Article> list =articleDao.getPageData(detachedCriteria,pageBean.getIndex(),pageBean.getPageSize());
        //计算
        pageBean.setList(list);
        System.out.println(pageBean);
        return pageBean;


    }

    @Override
    public void delete(Article article) {
       articleDao.delete(article);
    }

    @Override
    public List<Category> getCategory(Integer parentid) {
        List<Category> list = articleDao.getCategory(parentid);
        return list;
    }


}
