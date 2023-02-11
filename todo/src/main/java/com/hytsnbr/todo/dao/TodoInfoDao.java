package com.hytsnbr.todo.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.hytsnbr.todo.dto.TodoSearchCondition;
import com.hytsnbr.todo.dto.entity.TodoInfoEntity;

public interface TodoInfoDao {
    
    /**
     * 検索
     *
     * @param conditions 検索条件
     *
     * @return List of TodoInfo
     *
     * @throws DataAccessException DBクエリ失敗時
     */
    List<TodoInfoEntity> search(TodoSearchCondition conditions) throws DataAccessException;
}
