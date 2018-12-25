package com.newer.service;

import com.newer.dao.ArticleMapper;
import com.newer.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("articleService")
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
//不开启事务
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    //开启事务 如果没有新建一个,如果有那么加入事务 一般用于 增删改
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
    @Override
    public int addArticle(Article article) {

        return articleMapper.addArticle(article);
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
    @Override
    public int updateArticle(Article article) {

        return articleMapper.updateArticle(article);
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
    @Override
    public int deleteArticle(int articleId) {

        return articleMapper.deleteArticle(articleId);
    }

    @Override
    public Article findById(int articleId) {

        return articleMapper.findById(articleId);
    }

    @Override
    public List<Article> findAll() {

        return articleMapper.findAll();
    }
}
