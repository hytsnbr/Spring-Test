package com.hytsnbr.todo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hytsnbr.base_common.constant.URL;
import com.hytsnbr.todo.dto.TodoInfoResponse;
import com.hytsnbr.todo.service.TodoService;

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
