package com.newer.service;


import com.newer.dao.UserMapper;
import com.newer.domain.User;
import com.newer.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User findByParam(String userName, String pwd) {

        String password = MD5.getInstance().getMD5ofStr(pwd);

        return userMapper.findByParam(userName,password);

    }

    @Override
    public int add(String userName, String pwd) {

        String password = MD5.getInstance().getMD5ofStr(pwd);

        return userMapper.add(userName,password);

    }

    @Override
    public User findById(Integer id) {

        return userMapper.findById(id);
    }
}
