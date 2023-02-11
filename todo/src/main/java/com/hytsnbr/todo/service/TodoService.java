package com.hytsnbr.todo.service;

import java.util.List;

import com.hytsnbr.todo.dto.TodoInfoResponse;
import com.hytsnbr.todo.dto.entity.TodoInfoEntity;

public interface TodoService {
    
    TodoInfoResponse getTodoInfo(long id);
    
    List<TodoInfoResponse> getTodoList();
    
    boolean registerTodo(TodoInfoEntity todoInfoEntity);
    
    boolean updateTodo(TodoInfoEntity todoInfoEntity);
}
