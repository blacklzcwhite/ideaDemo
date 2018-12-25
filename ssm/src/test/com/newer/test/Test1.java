package com.newer.test;

import com.newer.domain.Author;
import com.newer.service.AuthorService;

import com.newer.util.MD5;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {

    @Test
    public void test1() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        AuthorService authorService = (AuthorService) ctx.getBean("authorService");

       Author author = authorService.findById(1);

        System.out.println(author.getName());



    }

}
