package com.hytsnbr.demo.todo.service.impl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.hytsnbr.demo.todo.dao.repository.TodoInfoRepository;
import com.hytsnbr.demo.todo.dto.TodoInfo;
import com.hytsnbr.demo.todo.service.TodoService;

@Service
public class TodoServiceImpl implements TodoService {

    private final TodoInfoRepository repository;

    public TodoServiceImpl(TodoInfoRepository repository) {
        this.repository = repository;
    }

    @Override
    public TodoInfo getTodoInfo(long id) throws Exception {
        return repository.findById(id);
    }

    @Override
    public List<TodoInfo> getTodoList() throws Exception {
        return repository.findAll();
    }

    @Override
    public boolean registerTodo(TodoInfo todoInfo) throws Exception {

        // Null Check
        Objects.requireNonNull(todoInfo);

        LocalDateTime insertAt = LocalDateTime.now();

        todoInfo.setCreateAt(Timestamp.valueOf(insertAt));
        todoInfo.setUpdateAt(Timestamp.valueOf(insertAt));
        TodoInfo result = repository.save(todoInfo);

        return Objects.nonNull(result);
    }

    @Override
    public boolean updateTodo(TodoInfo todoInfo) throws Exception {

        // Null Check
        Objects.requireNonNull(todoInfo);

        LocalDateTime updateAt = LocalDateTime.now();

        // Is Exist?
        if (repository.existsById(todoInfo.getId())) {
            todoInfo.setUpdateAt(Timestamp.valueOf(updateAt));
            TodoInfo result = repository.save(todoInfo);

            return Objects.nonNull(result);
        }

        throw new NullPointerException(""); // TODO: メッセージ設定
    }
}
