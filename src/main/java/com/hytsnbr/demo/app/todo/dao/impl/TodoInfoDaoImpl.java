package com.hytsnbr.demo.app.todo.dao.impl;

import java.util.Collections;
import java.util.List;

import com.hytsnbr.demo.app.todo.dao.TodoInfoDao;
import com.hytsnbr.demo.app.todo.dto.TodoInfo;
import com.hytsnbr.demo.app.todo.dto.TodoSearchCondition;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class TodoInfoDaoImpl implements TodoInfoDao {

    @Override
    public List<TodoInfo> search(TodoSearchCondition conditions) throws DataAccessException {
        // TODO Auto-generated method stub
        return Collections.emptyList();
    }
}
