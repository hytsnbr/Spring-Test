package com.hytsnbr.demo.app.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hytsnbr.demo.app.todo.dto.TodoInfo;
import com.hytsnbr.demo.app.todo.service.TodoService;
import com.hytsnbr.demo.constant.URL;

@Controller
public class TodoDetailController {

    private final TodoService todoService;

    public TodoDetailController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping(URL.URL_TODO_DETAIL + "/{id}")
    public String index(@PathVariable long id, Model model) throws Exception {

        TodoInfo todoInfo = todoService.getTodoInfo(id);
        model.addAttribute("todoInfo", todoInfo);

        return "todo/detail";
    }
}
