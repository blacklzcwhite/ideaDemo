package com.newer.controller;


import com.newer.domain.Article;
import com.newer.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//当前Controller所有方法返回值都是自动转换成json数据响应给客户端
@RequestMapping("/articles")
public class ArticleController {

    //自动注入
    @Autowired
    private ArticleService articleService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Article> findAll() {

        return articleService.findAll();
    }

    @GetMapping("/{articleId}")
    public Article findById(@PathVariable("articleId") int articleId) {

        return articleService.findById(articleId);
    }

    @PostMapping
    public Map<String, Object> addArticle(Article article) {
        int count = articleService.addArticle(article);

        Map<String, Object> results = new HashMap<>();

        results.put("count", count);

        return results;

    }

    @DeleteMapping("/{articleId}")
    public Map<String, Object> deleteArticle(@PathVariable("articleId") int articleId) {
        int count = articleService.deleteArticle(articleId);

        Map<String, Object> results = new HashMap<>();

        results.put("count", count);

        return results;
    }

    @RequestMapping(value = "/{articleId}",method = RequestMethod.PUT)
    public Map<String, Object> updateArticle(@PathVariable("articleId")int articleId, Article article) {
        System.out.println(article);

       // article.setArticleId(articleId);

        int count = articleService.updateArticle(article);

        Map<String, Object> results = new HashMap<>();

        results.put("count", count);

        return results;
    }


}
