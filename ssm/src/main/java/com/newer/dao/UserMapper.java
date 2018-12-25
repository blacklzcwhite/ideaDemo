package com.newer.dao;

import com.newer.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Select(" select * from tb_user where username=#{userName} and pwd = #{pwd}")
    User findByParam(@Param("userName") String userName, @Param("pwd") String pwd);

    @Select(" select * from tb_user")
    List<User> findAll();

    @Insert(" insert into tb_user(userId,username,pwd) values(null,#{userName},#{pwd})")
    int add(@Param("userName") String userName, @Param("pwd") String pwd);


    @Select(" select * from tb_user where userid=#{userId}")
    User findById(@Param("userId")Integer id);
}
