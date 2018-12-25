package com.newer.dao;


import com.newer.domain.Author;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface AuthorMapper {


    @Select("select * from author where id= #{id}")
    Author findById(@Param("id") int id);


    int delete(@Param("id")int id);

    @Select("select * from author")
    List<Author> findAll();

}
