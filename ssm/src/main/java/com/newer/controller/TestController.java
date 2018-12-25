package com.newer.controller;


import com.newer.domain.Article;
import com.newer.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/text")
@SessionAttributes({"article","article1"})
public class TestController {

    @Autowired
    private ArticleService articleService;

    //在当前控制器类任何控制器方法执行前
    //将方法返回值放入modelMap
    @ModelAttribute
    public Article getArticle() {

        System.out.println("getArticle()1");

        return articleService.findAll().get(0);
    }

    @RequestMapping("/test1")
    public String test1() {

        System.out.println("test1()");

        return "index";
    }


    @ModelAttribute("/article1")
    @RequestMapping("/test2")
    public Article getArticle2() {

        System.out.println("getArticle()2");

        return articleService.findAll().get(1);
    }


    @RequestMapping("/test3")
    public  String test3(@ModelAttribute("article") Article article){

        article.setTitle("test3"+article.getTitle());

        return "index";
    }

    @RequestMapping("/test4")
    public String test4(){

        int i = Integer.parseInt("abc");

        return  "index";

    }



}
