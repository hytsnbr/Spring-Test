package com.hytsnbr.todo.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hytsnbr.todo.dto.entity.TodoInfoEntity;

public interface TodoInfoRepository extends JpaRepository<TodoInfoEntity, Long> {
    
}
