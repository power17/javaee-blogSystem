package com.itlike.web.service.impl;

import com.itlike.web.dao.ArticleDao;
import com.itlike.web.domain.Article;
import com.itlike.web.service.ArticleService;
import lombok.Setter;

import java.util.List;

public class ArticleServiceImpl implements ArticleService {
    @Setter
    private ArticleDao articleDao;
    @Override
    public List<Article> getAllArticle( ) {
        List<Article> allArticle = articleDao.getAllArticle();
        return allArticle;
    }
}
