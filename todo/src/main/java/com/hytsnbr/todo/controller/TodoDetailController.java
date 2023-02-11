package com.hytsnbr.todo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hytsnbr.spring_test.base_common.constant.URL;
import com.hytsnbr.todo.dto.TodoInfoResponse;
import com.hytsnbr.todo.service.TodoService;

@RestController
public class TodoDetailController {
    
    private final TodoService todoService;
    
    public TodoDetailController(TodoService todoService) {
        this.todoService = todoService;
    }
    
    @GetMapping(URL.URL_TODO_DETAIL + "/{id}")
    public TodoInfoResponse index(@PathVariable long id) {
        return todoService.getTodoInfo(id);
    }
}
