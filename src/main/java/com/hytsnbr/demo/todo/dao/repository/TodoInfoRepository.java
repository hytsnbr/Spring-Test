package com.hytsnbr.demo.todo.dao.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;

import com.hytsnbr.demo.todo.dto.TodoInfo;

public interface TodoInfoRepository extends CrudRepository<TodoInfo, Long> {

    List<TodoInfo> findAll() throws DataAccessException;

    TodoInfo findById(long id) throws DataAccessException;

    TodoInfo save(TodoInfo todoInfo) throws DataAccessException;

    boolean existsById(Long id) throws DataAccessException;
}
