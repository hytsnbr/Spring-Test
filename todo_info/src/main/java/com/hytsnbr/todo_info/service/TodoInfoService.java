package com.hytsnbr.todo_info.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hytsnbr.todo_info.dto.TodoInfoRequest;
import com.hytsnbr.todo_info.dto.TodoInfoResponse;
import com.hytsnbr.todo_info.dto.TodoInfoSearchCondition;

public interface TodoInfoService {
    
    TodoInfoResponse getTodoInfo(long id);
    
    Page<TodoInfoResponse> search(TodoInfoSearchCondition condition, Pageable pageable);
    
    List<TodoInfoResponse> getTodoList(Pageable pageable);
    
    TodoInfoResponse create(TodoInfoRequest request);
    
    TodoInfoResponse update(long id, TodoInfoRequest request);
    
    TodoInfoResponse upsert(long id, TodoInfoRequest request);
    
    void delete(long id);
}
