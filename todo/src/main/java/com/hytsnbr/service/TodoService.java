package com.hytsnbr.service;

import java.util.List;

import com.hytsnbr.dto.TodoInfoResponse;
import com.hytsnbr.dto.entity.TodoInfoEntity;

public interface TodoService {
    
    TodoInfoResponse getTodoInfo(long id);
    
    List<TodoInfoResponse> getTodoList();
    
    boolean registerTodo(TodoInfoEntity todoInfoEntity);
    
    boolean updateTodo(TodoInfoEntity todoInfoEntity);
}
