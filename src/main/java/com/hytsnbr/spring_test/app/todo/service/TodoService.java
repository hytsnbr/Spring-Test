package com.hytsnbr.spring_test.app.todo.service;

import java.util.List;

import com.hytsnbr.spring_test.app.todo.dto.TodoInfoResponse;
import com.hytsnbr.spring_test.app.todo.dto.entity.TodoInfoEntity;

public interface TodoService {
    
    TodoInfoResponse getTodoInfo(long id);
    
    List<TodoInfoResponse> getTodoList();
    
    boolean registerTodo(TodoInfoEntity todoInfoEntity);
    
    boolean updateTodo(TodoInfoEntity todoInfoEntity);
}
