package com.newer.service;


import com.newer.domain.Author;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuthorService {

    Author findById(@Param("id") int id);

    int delete(int id);

}
