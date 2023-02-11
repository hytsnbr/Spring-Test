package com.hytsnbr.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hytsnbr.dto.entity.TodoInfoEntity;

public interface TodoInfoRepository extends JpaRepository<TodoInfoEntity, Long> {
    
}
