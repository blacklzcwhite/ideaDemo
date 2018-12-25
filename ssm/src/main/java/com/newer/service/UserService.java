package com.newer.service;

import com.newer.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {

        List<User> findAll();

        User findByParam(String userName,String pwd);

        int add(String userName,String pwd);

        User findById(@Param("userId")Integer id);
}
