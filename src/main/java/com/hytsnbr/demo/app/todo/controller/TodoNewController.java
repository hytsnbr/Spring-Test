package com.hytsnbr.demo.app.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hytsnbr.demo.app.todo.dto.TodoInfo;
import com.hytsnbr.demo.constant.URL;

@Controller
public class TodoNewController {

  @GetMapping(URL.URL_TODO_NEW)
  public String index(Model model) throws Exception {

    return "todo/new";
  }

  @PostMapping(URL.URL_TODO_NEW)
  public String validate(
      @Validated @ModelAttribute("todoInfo") TodoInfo todoInfo,
      BindingResult errors,
      Model model) throws Exception {

    if (errors.hasErrors()) {
      return "todo/new";
    }

    model.addAttribute("todoInfo", todoInfo);

    return "redirect:new/confirm";
  }

  @PostMapping(URL.URL_TODO_NEW_CONFIRM)
  public String confirm(
      @Validated @ModelAttribute("todoInfo") TodoInfo todoInfo,
      BindingResult errors,
      Model model,
      RedirectAttributes redirectAttributes) throws Exception {

    if (errors.hasErrors()) {
      redirectAttributes.addFlashAttribute("todoInfo", todoInfo);

      return "redirect:new";
    }

    model.addAttribute("todoInfo", todoInfo);

    return "todo/new/confirm";
  }

  @PostMapping(value = URL.URL_TODO_NEW_CONFIRM, params = "enter")
  public String confirmEnter(
      @Validated @ModelAttribute("todoInfo") TodoInfo todoInfo,
      BindingResult errors,
      Model model,
      RedirectAttributes redirectAttributes) throws Exception {

    if (errors.hasErrors()) {
      redirectAttributes.addFlashAttribute("todoInfo", todoInfo);

      return "redirect:new/confirm";
    }

    model.addAttribute("todoInfo", todoInfo);

    return "todo/new/confirm";
  }
}
