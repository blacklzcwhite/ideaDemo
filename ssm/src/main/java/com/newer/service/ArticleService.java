package com.newer.service;


import com.newer.domain.Article;

import java.util.List;

public interface ArticleService {

    int addArticle(Article article);

    int updateArticle(Article article);

    int deleteArticle(int articleId);

    Article findById(int articleId);

    List<Article> findAll();

}
