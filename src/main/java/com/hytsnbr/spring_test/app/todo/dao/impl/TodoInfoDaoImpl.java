package com.hytsnbr.spring_test.app.todo.dao.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.hytsnbr.spring_test.app.todo.dao.TodoInfoDao;
import com.hytsnbr.spring_test.app.todo.dto.TodoSearchCondition;
import com.hytsnbr.spring_test.app.todo.dto.entity.TodoInfoEntity;

@Repository
public class TodoInfoDaoImpl implements TodoInfoDao {
    
    @Override
    public List<TodoInfoEntity> search(TodoSearchCondition conditions) throws DataAccessException {
        // TODO Auto-generated method stub
        return Collections.emptyList();
    }
}
