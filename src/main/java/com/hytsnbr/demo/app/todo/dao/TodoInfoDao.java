package com.hytsnbr.demo.app.todo.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.hytsnbr.demo.app.todo.dto.TodoInfo;
import com.hytsnbr.demo.app.todo.dto.TodoSearchCondition;

public interface TodoInfoDao {

    /**
     * 検索
     * 
     * @param conditions
     * @return List of TodoInfo
     * @throws DataAccessException
     */
    List<TodoInfo> search(TodoSearchCondition conditions) throws DataAccessException;
}
