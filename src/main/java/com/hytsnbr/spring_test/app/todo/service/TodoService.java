package com.hytsnbr.spring_test.app.todo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hytsnbr.spring_test.app.todo.dto.TodoInfoRequest;
import com.hytsnbr.spring_test.app.todo.dto.TodoInfoResponse;
import com.hytsnbr.spring_test.app.todo.dto.TodoInfoSearchCondition;

public interface TodoService {
    
    TodoInfoResponse getTodoInfo(long id);
    
    Page<TodoInfoResponse> search(TodoInfoSearchCondition condition, Pageable pageable);
    
    List<TodoInfoResponse> getTodoList(Pageable pageable);
    
    TodoInfoResponse create(TodoInfoRequest request);
    
    TodoInfoResponse update(long id, TodoInfoRequest request);
    
    TodoInfoResponse upsert(long id, TodoInfoRequest request);
    
    void delete(long id);
}
