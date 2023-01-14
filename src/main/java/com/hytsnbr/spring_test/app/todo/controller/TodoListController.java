package com.hytsnbr.spring_test.app.todo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hytsnbr.spring_test.app.todo.dto.TodoInfoResponse;
import com.hytsnbr.spring_test.app.todo.service.TodoService;
import com.hytsnbr.spring_test.constant.URL;

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
