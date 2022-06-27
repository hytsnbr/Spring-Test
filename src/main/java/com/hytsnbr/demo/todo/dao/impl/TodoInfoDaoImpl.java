package com.hytsnbr.demo.todo.dao.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.hytsnbr.demo.todo.dao.TodoInfoDao;
import com.hytsnbr.demo.todo.dto.TodoInfo;
import com.hytsnbr.demo.todo.dto.TodoSearchCondition;

@Repository
public class TodoInfoDaoImpl implements TodoInfoDao {

    @Override
    public List<TodoInfo> search(TodoSearchCondition conditions) throws DataAccessException {
        // TODO Auto-generated method stub
        return Collections.emptyList();
    }
}
