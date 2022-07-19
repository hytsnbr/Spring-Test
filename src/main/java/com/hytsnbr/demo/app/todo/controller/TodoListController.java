package com.hytsnbr.demo.app.todo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hytsnbr.demo.app.todo.dto.TodoInfo;
import com.hytsnbr.demo.app.todo.service.TodoService;
import com.hytsnbr.demo.constant.Processing;
import com.hytsnbr.demo.constant.URL;

@Controller
public class TodoListController {

    private final TodoService todoService;

    public TodoListController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping(URL.URL_TODO_LIST)
    public String index(Model model) throws Exception {

        List<TodoInfo> todoInfoList = todoService.getTodoList();
        model.addAttribute("todoInfoList", todoInfoList);

        Processing[] processingList = Processing.values();
        model.addAttribute("processingList", processingList);

        return "todo/list";
    }
}
