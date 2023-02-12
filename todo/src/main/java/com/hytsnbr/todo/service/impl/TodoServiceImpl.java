package com.hytsnbr.todo.service.impl;

import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.hytsnbr.base_common.exception.common.SystemException;
import com.hytsnbr.base_common.exception.database.SearchCountLimitOverException;
import com.hytsnbr.todo.constant.TodoInfoPageableConst;
import com.hytsnbr.todo.dao.jpa.TodoInfoRepository;
import com.hytsnbr.todo.dao.jpa.specification.TodoInfoSpecification;
import com.hytsnbr.todo.dto.TodoInfoRequest;
import com.hytsnbr.todo.dto.TodoInfoResponse;
import com.hytsnbr.todo.dto.TodoInfoSearchCondition;
import com.hytsnbr.todo.entity.TodoInfoEntity;
import com.hytsnbr.todo.service.TodoService;

@Service
public class TodoServiceImpl implements TodoService {
    
    private final TodoInfoRepository repository;
    
    public TodoServiceImpl(TodoInfoRepository repository) {
        this.repository = repository;
    }
    
    private TodoInfoResponse todoEntity2Response(TodoInfoEntity entity) {
        return new TodoInfoResponse(
            entity.getId(),
            entity.getProcess(),
            entity.getText(),
            entity.getCreateAt(),
            entity.getUpdateAt()
        );
    }
    
    private List<TodoInfoResponse> todoEntity2Response(List<TodoInfoEntity> entities) {
        return entities.stream()
                       .map(this::todoEntity2Response)
                       .toList();
    }
    
    private Page<TodoInfoResponse> createTodoInfoResponsePager(Page<TodoInfoEntity> todoInfoEntityPager) {
        return new PageImpl<>(
            this.todoEntity2Response(todoInfoEntityPager.getContent()),
            todoInfoEntityPager.getPageable(),
            todoInfoEntityPager.getTotalElements()
        );
    }
    
    @Override
    public TodoInfoResponse getTodoInfo(long id) throws SystemException {
        var entity = repository.findById(id).orElseThrow(SystemException::new);
        
        return this.todoEntity2Response(entity);
    }
    
    @Override
    public Page<TodoInfoResponse> search(TodoInfoSearchCondition condition, Pageable pageable) {
        var spec = new TodoInfoSpecification();
        var searchResult = repository.findAll(
            Specification.where(spec.idEqual(condition.id()))
                         .or(spec.processEqual(condition.process()))
                         .or(spec.textContain(condition.text())),
            pageable
        );
        
        // 検索結果総個数チェック
        if (searchResult.getTotalElements() > TodoInfoPageableConst.SEARCH_CAN_DISPLAY_COUNT) {
            throw new SearchCountLimitOverException();
        }
        
        return this.createTodoInfoResponsePager(searchResult);
    }
    
    @Override
    public List<TodoInfoResponse> getTodoList(Pageable pageable) {
        var result = repository.findAll(pageable);
        
        return this.todoEntity2Response(result.getContent());
    }
    
    @Transactional
    @Override
    public TodoInfoResponse create(TodoInfoRequest request) {
        var entity = TodoInfoEntity.create(request.process(), request.text());
        var result = repository.saveAndFlush(entity);
        
        return this.todoEntity2Response(result);
    }
    
    @Transactional
    @Override
    public TodoInfoResponse update(long id, TodoInfoRequest request) {
        var entity = repository.findById(id).orElseThrow(SystemException::new);
        entity.update(request.process(), request.text());
        var result = repository.saveAndFlush(entity);
        
        return this.todoEntity2Response(result);
    }
    
    @Transactional
    @Override
    public TodoInfoResponse upsert(long id, TodoInfoRequest request) {
        var entity = repository.findById(id).orElse(new TodoInfoEntity());
        entity.update(request.process(), request.text());
        var result = repository.saveAndFlush(entity);
        
        return this.todoEntity2Response(result);
    }
    
    @Transactional
    @Override
    public void delete(long id) {
        var entity = repository.findById(id).orElseThrow(SystemException::new);
        
        repository.delete(entity);
    }
}
