package com.hytsnbr.todo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hytsnbr.spring_test.base_common.constant.URL;
import com.hytsnbr.todo.dto.TodoInfoResponse;
import com.hytsnbr.todo.service.TodoService;

@RestController
public class TodoEditController {
    
    private final TodoService todoService;
    
    public TodoEditController(TodoService todoService) {
        this.todoService = todoService;
    }
    
    @GetMapping(URL.URL_TODO_EDIT + "/{id}")
    public TodoInfoResponse index(@PathVariable long id) {
        return todoService.getTodoInfo(id);
    }
}
