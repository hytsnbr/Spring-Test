package com.hytsnbr.demo.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.hytsnbr.demo.constant.URL;
import com.hytsnbr.demo.todo.dto.TodoInfo;
import com.hytsnbr.demo.todo.service.TodoService;

@Controller
public class TodoEditController {

    private final TodoService todoService;

    public TodoEditController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping(URL.URL_TODO_EDIT + "/{id}")
    public String index(@PathVariable long id, Model model) throws Exception {

        TodoInfo todoInfo = todoService.getTodoInfo(id);
        model.addAttribute("todoInfo", todoInfo);

        return "todo/edit";
    }

    @PostMapping(URL.URL_TODO_EDIT_CONFIRM)
    public String confirm(@Validated TodoInfo todoInfo, BindingResult bindingResult, Model model) throws Exception {

        if (bindingResult.hasErrors()) {
            model.addAttribute("todoInfo", todoInfo);

            return "todo/edit";
        }

        // insert
        todoService.updateTodo(todoInfo);

        return "redirect:" + URL.URL_TODO_DETAIL + "/" + todoInfo.getId();
    }
}
