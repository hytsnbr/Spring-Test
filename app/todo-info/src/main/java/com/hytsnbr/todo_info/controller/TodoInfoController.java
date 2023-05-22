package com.hytsnbr.todo_info.controller;

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

import com.hytsnbr.base_common.controller.BaseController;
import com.hytsnbr.base_common.validator.AllowedSortProperties;
import com.hytsnbr.base_common.validator.PagerSizeLimit;
import com.hytsnbr.todo_info.constant.TodoInfoPageableConst;
import com.hytsnbr.todo_info.dto.TodoInfoRequest;
import com.hytsnbr.todo_info.dto.TodoInfoResponse;
import com.hytsnbr.todo_info.dto.TodoInfoSearchCondition;
import com.hytsnbr.todo_info.entity.TodoInfoEntity;
import com.hytsnbr.todo_info.service.TodoInfoService;

@Validated
@RestController
@RequestMapping("/todo")
public class TodoInfoController extends BaseController {
    
    private final TodoInfoService todoInfoService;
    
    public TodoInfoController(TodoInfoService todoInfoService) {
        this.todoInfoService = todoInfoService;
    }
    
    @GetMapping("/search")
    public Page<TodoInfoResponse> search(
        @ModelAttribute
        TodoInfoSearchCondition condition,
        @PagerSizeLimit(max = TodoInfoPageableConst.SIZE_MAX)
        @AllowedSortProperties(properties = {
            TodoInfoEntity.COLUMN_NAME_ID, TodoInfoEntity.COLUMN_NAME_CREATE_AT, TodoInfoEntity.COLUMN_NAME_ID
        })
        @PageableDefault(size = TodoInfoPageableConst.SIZE_DEFAULT, sort = TodoInfoPageableConst.SORT_DEFAULT)
        Pageable pageable
    ) {
        return todoInfoService.search(condition, pageable);
    }
    
    @GetMapping("/list")
    public List<TodoInfoResponse> list(
        @PagerSizeLimit(max = TodoInfoPageableConst.SIZE_MAX)
        @AllowedSortProperties(properties = {
            TodoInfoEntity.COLUMN_NAME_ID, TodoInfoEntity.COLUMN_NAME_CREATE_AT, TodoInfoEntity.COLUMN_NAME_ID
        })
        @PageableDefault(size = TodoInfoPageableConst.SIZE_DEFAULT, sort = TodoInfoPageableConst.SORT_DEFAULT)
        Pageable pageable
    ) {
        return todoInfoService.getTodoList(pageable);
    }
    
    @GetMapping("/detail/{id}")
    public TodoInfoResponse detail(@PathVariable long id) {
        return todoInfoService.getTodoInfo(id);
    }
    
    @PostMapping("/create")
    public TodoInfoResponse create(@Validated @RequestBody TodoInfoRequest request) {
        return todoInfoService.create(request);
    }
    
    @PutMapping("/update/{id}")
    public TodoInfoResponse upsert(@PathVariable long id, @Validated @RequestBody TodoInfoRequest request) {
        return todoInfoService.upsert(id, request);
    }
    
    @PatchMapping("/update/{id}")
    public TodoInfoResponse update(@PathVariable long id, @Validated @RequestBody TodoInfoRequest request) {
        return todoInfoService.update(id, request);
    }
    
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        todoInfoService.delete(id);
    }
}
