package com.hytsnbr.todo.service.impl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.hytsnbr.spring_test.base_common.exception.common.SystemException;
import com.hytsnbr.todo.dao.jpa.TodoInfoRepository;
import com.hytsnbr.todo.dto.TodoInfoResponse;
import com.hytsnbr.todo.dto.entity.TodoInfoEntity;
import com.hytsnbr.todo.service.TodoService;

@Service
public class TodoServiceImpl implements TodoService {
    
    private final TodoInfoRepository repository;
    
    private final ConversionService conversionService;
    
    public TodoServiceImpl(TodoInfoRepository repository, ConversionService conversionService) {
        this.repository = repository;
        this.conversionService = conversionService;
    }
    
    private TodoInfoResponse todoEntity2Response(TodoInfoEntity entity) {
        return conversionService.convert(entity, TodoInfoResponse.class);
    }
    
    private List<TodoInfoResponse> todoEntity2Response(List<TodoInfoEntity> entities) {
        return entities.stream()
                       .map(entity -> conversionService.convert(entity, TodoInfoResponse.class))
                       .toList();
    }
    
    @Override
    public TodoInfoResponse getTodoInfo(long id) throws SystemException {
        var entity = repository.findById(id).orElseThrow(SystemException::new);
        
        return this.todoEntity2Response(entity);
    }
    
    @Override
    public List<TodoInfoResponse> getTodoList() {
        return this.todoEntity2Response(repository.findAll());
    }
    
    @Override
    public boolean registerTodo(TodoInfoEntity todoInfoEntity) {
        
        // Null Check
        Objects.requireNonNull(todoInfoEntity);
        
        LocalDateTime insertAt = LocalDateTime.now();
        
        todoInfoEntity.setCreateAt(Timestamp.valueOf(insertAt));
        todoInfoEntity.setUpdateAt(Timestamp.valueOf(insertAt));
        TodoInfoEntity result = repository.save(todoInfoEntity);
        
        return Objects.nonNull(result);
    }
    
    @Override
    public boolean updateTodo(TodoInfoEntity todoInfoEntity) {
        
        // Null Check
        Objects.requireNonNull(todoInfoEntity);
        
        LocalDateTime updateAt = LocalDateTime.now();
        
        // Is Exist?
        if (repository.existsById(todoInfoEntity.getId())) {
            todoInfoEntity.setUpdateAt(Timestamp.valueOf(updateAt));
            TodoInfoEntity result = repository.save(todoInfoEntity);
            
            return Objects.nonNull(result);
        }
        
        throw new NullPointerException(""); // TODO: メッセージ設定
    }
}
