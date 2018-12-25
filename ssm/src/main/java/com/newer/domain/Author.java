package com.newer.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;

public class Author implements Serializable {

    private Integer id;

    private String  name;

    //忽略 不传给前端
    @JsonIgnore
    private List<Author> list;

    public List<Author> getList() {
        return list;
    }

    public void setList(List<Author> list) {
        this.list = list;
    }

    public Author() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
