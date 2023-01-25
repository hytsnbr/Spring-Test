package com.hytsnbr.spring_test.app.todo.controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hytsnbr.spring_test.app.todo.dto.entity.TodoInfoEntity;
import com.hytsnbr.spring_test.base_common.constant.URL;

@RestController
public class TodoNewController {
    
    @GetMapping(URL.URL_TODO_NEW)
    public String index() {
        
        return "todo/new";
    }
    
    @PostMapping(URL.URL_TODO_NEW)
    public String validate(
        @Validated @ModelAttribute("todoInfo") TodoInfoEntity todoInfoEntity, BindingResult errors
    ) {
        
        if (errors.hasErrors()) {
            return "todo/new";
        }
        
        return "redirect:new/confirm";
    }
    
    @PostMapping(URL.URL_TODO_NEW_CONFIRM)
    public String confirm(
        @Validated @ModelAttribute("todoInfo") TodoInfoEntity todoInfoEntity, BindingResult errors,
        RedirectAttributes redirectAttributes
    ) {
        
        if (errors.hasErrors()) {
            redirectAttributes.addFlashAttribute("todoInfo", todoInfoEntity);
            
            return "redirect:new";
        }
        
        return "todo/new/confirm";
    }
    
    @PostMapping(value = URL.URL_TODO_NEW_CONFIRM, params = "enter")
    public String confirmEnter(
        @Validated @ModelAttribute("todoInfo") TodoInfoEntity todoInfoEntity,
        BindingResult errors, RedirectAttributes redirectAttributes
    ) {
        
        if (errors.hasErrors()) {
            redirectAttributes.addFlashAttribute("todoInfo", todoInfoEntity);
            
            return "redirect:new/confirm";
        }
        
        return "todo/new/confirm";
    }
}
