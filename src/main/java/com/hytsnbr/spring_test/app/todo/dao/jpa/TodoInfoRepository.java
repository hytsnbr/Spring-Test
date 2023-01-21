package com.hytsnbr.spring_test.app.todo.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.hytsnbr.spring_test.app.todo.dto.entity.TodoInfoEntity;

@Repository
public interface TodoInfoRepository
    extends JpaRepository<TodoInfoEntity, Long>, JpaSpecificationExecutor<TodoInfoEntity> {
    
}
