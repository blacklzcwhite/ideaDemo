package com.newer.dao;

import com.newer.domain.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ArticleMapper {


    @Insert("insert into article values(null,#{title}," +
            "#{content},#{author.id})")

    int addArticle(Article article);

    @Update("update article set title=#{title}," +
            "content=#{content},auid=#{author.id} where " +
            "articleid=#{articleId}")
    int updateArticle(Article article);

    @Delete("delete from article where articleid=#{articleId}")
    int deleteArticle(@Param("articleId") int articleId);

    @Results({@Result(id = true,property = "articleId",column = "articleid"),
            @Result(property = "title",column = "title"),
            @Result(property = "content",column = "content"),
            @Result(property = "author",column = "auid",
                    javaType = com.newer.domain.Author.class,
                    one = @One(select = "com.newer.dao.AuthorMapper.findById"))})
    @Select("select * from article where articleid=#{articleId}")
    Article findById(@Param("articleId") int articleId);

    @ResultMap(value = "com.newer.dao.ArticleMapper.article1")
    @Select("SELECT * FROM article b LEFT JOIN " +
            "       author a on b.auid=a.id")
    List<Article> findAll();



}
