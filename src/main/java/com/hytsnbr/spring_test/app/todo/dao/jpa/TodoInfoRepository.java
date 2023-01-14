package com.hytsnbr.spring_test.app.todo.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hytsnbr.spring_test.app.todo.dto.entity.TodoInfoEntity;

public interface TodoInfoRepository extends JpaRepository<TodoInfoEntity, Long> {
    
}
