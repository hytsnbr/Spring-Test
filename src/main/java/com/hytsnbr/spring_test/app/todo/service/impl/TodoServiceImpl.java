package com.hytsnbr.spring_test.app.todo.service.impl;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Objects;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.hytsnbr.spring_test.app.todo.dao.jpa.TodoInfoRepository;
import com.hytsnbr.spring_test.app.todo.dao.jpa.TodoInfoSpecification;
import com.hytsnbr.spring_test.app.todo.dto.TodoInfoRequest;
import com.hytsnbr.spring_test.app.todo.dto.TodoInfoResponse;
import com.hytsnbr.spring_test.app.todo.dto.TodoInfoSearchCondition;
import com.hytsnbr.spring_test.app.todo.dto.entity.TodoInfoEntity;
import com.hytsnbr.spring_test.app.todo.service.TodoService;
import com.hytsnbr.spring_test.exception.common.SystemException;

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
        var contents = this.todoEntity2Response(searchResult.getContent());
        
        return new PageImpl<>(contents, searchResult.getPageable(), searchResult.getTotalElements());
    }
    
    @Override
    public List<TodoInfoResponse> getTodoList(Pageable pageable) {
        var result = repository.findAll(pageable);
        
        return this.todoEntity2Response(result.getContent());
    }
    
    @Transactional
    @Override
    public TodoInfoResponse create(TodoInfoRequest request) {
        var entity = new TodoInfoEntity();
        entity.setProcess(request.process());
        entity.setText(request.text());
        
        var result = repository.saveAndFlush(entity);
        return this.todoEntity2Response(result);
    }
    
    @Transactional
    @Override
    public TodoInfoResponse update(long id, TodoInfoRequest request) {
        var entity = repository.findById(id).orElseThrow(SystemException::new);
        entity.setProcess(Objects.nonNull(request.process()) ? request.process() : entity.getProcess());
        entity.setText(Objects.nonNull(request.text()) ? request.text() : entity.getText());
        
        var result = repository.saveAndFlush(entity);
        return this.todoEntity2Response(result);
    }
    
    @Transactional
    @Override
    public TodoInfoResponse upsert(long id, TodoInfoRequest request) {
        var entity = repository.findById(id).orElse(new TodoInfoEntity());
        entity.setProcess(request.process());
        entity.setText(request.text());
        
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
