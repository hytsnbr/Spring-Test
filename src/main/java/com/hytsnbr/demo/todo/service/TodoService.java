package com.hytsnbr.demo.todo.service;

import java.util.List;

import com.hytsnbr.demo.todo.dto.TodoInfo;

public interface TodoService {

    TodoInfo getTodoInfo(long id) throws Exception;

    List<TodoInfo> getTodoList() throws Exception;

    boolean registerTodo(TodoInfo todoInfo) throws Exception;

    boolean updateTodo(TodoInfo todoInfo) throws Exception;
}
