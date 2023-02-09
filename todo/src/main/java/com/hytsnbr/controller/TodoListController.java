package com.hytsnbr.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hytsnbr.dto.TodoInfoResponse;
import com.hytsnbr.service.TodoService;
import com.hytsnbr.spring_test.base_common.constant.URL;

@RestController
public class TodoListController {
    
    private final TodoService todoService;
    
    public TodoListController(TodoService todoService) {
        this.todoService = todoService;
    }
    
    @GetMapping(URL.URL_TODO_LIST)
    public List<TodoInfoResponse> index() {
        return todoService.getTodoList();
    }
}
