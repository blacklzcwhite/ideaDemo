package com.newer.service;


import com.newer.dao.AuthorMapper;
import com.newer.domain.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("authorService")

/*事务处理*/
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public class AuthorServiceImpl implements AuthorService {
    /*自动绑定*/
    @Autowired
    private AuthorMapper authorMapper;


    @Override
    public Author findById(int id) {

        return authorMapper.findById(id);

    }

    @Transactional(propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            rollbackFor = Exception.class)
    @Override
    public int delete(int id) {

        return authorMapper.delete(id);

    }


}
