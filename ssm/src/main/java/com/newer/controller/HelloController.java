package com.newer.controller;

import com.newer.domain.Author;
import com.newer.domain.User;

import com.newer.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class HelloController {

 /*  *//* @Autowired
    private AuthorService authorService;*//*

    @RequestMapping("/hello")
    public String hello() {

        System.out.println("hello方法被调用了");

        return "index"; //视图名
    }

    @RequestMapping("/login")
    public String login(String userName, String pwd) {

        System.out.println(userName + ":" + pwd);

        return "index";
    }

    @RequestMapping("/login1")
    public String login1(User user) {

        System.out.println(user.getUserName() + ":" + user.getPwd());

        return "index";
    }

   *//* @RequestMapping("/author")
    public String list(Map<String, List> map) {

        return "index";
    }*//*
*/
}
