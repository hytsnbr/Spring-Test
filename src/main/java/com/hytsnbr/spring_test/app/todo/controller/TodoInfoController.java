package com.hytsnbr.spring_test.app.todo.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hytsnbr.spring_test.app.todo.constant.TodoInfoPageableConst;
import com.hytsnbr.spring_test.app.todo.dto.TodoInfoRequest;
import com.hytsnbr.spring_test.app.todo.dto.TodoInfoResponse;
import com.hytsnbr.spring_test.app.todo.dto.TodoInfoSearchCondition;
import com.hytsnbr.spring_test.app.todo.entity.TodoInfoEntity_;
import com.hytsnbr.spring_test.app.todo.service.TodoService;
import com.hytsnbr.spring_test.base_common.controller.BaseController;
import com.hytsnbr.spring_test.base_common.validator.AllowedSortProperties;
import com.hytsnbr.spring_test.base_common.validator.PagerSizeLimit;

@Validated
@RestController
@RequestMapping("/todo")
public class TodoInfoController extends BaseController {
    
    private final TodoService todoService;
    
    public TodoInfoController(TodoService todoService) {
        this.todoService = todoService;
    }
    
    @GetMapping("/search")
    public Page<TodoInfoResponse> search(
        @ModelAttribute
        TodoInfoSearchCondition condition,
        @PagerSizeLimit(max = TodoInfoPageableConst.SIZE_MAX)
        @AllowedSortProperties(properties = { TodoInfoEntity_.ID, TodoInfoEntity_.CREATE_AT, TodoInfoEntity_.ID })
        @PageableDefault(size = TodoInfoPageableConst.SIZE_DEFAULT, sort = TodoInfoPageableConst.SORT_DEFAULT)
        Pageable pageable
    ) {
        return todoService.search(condition, pageable);
    }
    
    @GetMapping("/list")
    public List<TodoInfoResponse> list(
        @PagerSizeLimit(max = TodoInfoPageableConst.SIZE_MAX)
        @AllowedSortProperties(properties = { TodoInfoEntity_.ID, TodoInfoEntity_.CREATE_AT, TodoInfoEntity_.ID })
        @PageableDefault(size = TodoInfoPageableConst.SIZE_DEFAULT, sort = TodoInfoPageableConst.SORT_DEFAULT)
        Pageable pageable
    ) {
        return todoService.getTodoList(pageable);
    }
    
    @GetMapping("/detail/{id}")
    public TodoInfoResponse detail(@PathVariable long id) {
        return todoService.getTodoInfo(id);
    }
    
    @PostMapping("/create")
    public TodoInfoResponse create(@Validated @RequestBody TodoInfoRequest request) {
        return todoService.create(request);
    }
    
    @PutMapping("/update/{id}")
    public TodoInfoResponse upsert(@PathVariable long id, @Validated @RequestBody TodoInfoRequest request) {
        return todoService.upsert(id, request);
    }
    
    @PatchMapping("/update/{id}")
    public TodoInfoResponse update(@PathVariable long id, @Validated @RequestBody TodoInfoRequest request) {
        return todoService.update(id, request);
    }
    
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        todoService.delete(id);
    }
}
