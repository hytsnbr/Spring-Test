package com.hytsnbr.todo_info.dao.jpa.specification;

import java.time.LocalDate;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.hytsnbr.todo_info.entity.TodoInfoEntity;

public class TodoInfoSpecification {
    
    public Specification<TodoInfoEntity> idEqual(Long id) {
        return Objects.isNull(id)
               ? null
               : (root, query, builder) -> builder.equal(root.get(TodoInfoEntity.COLUMN_NAME_ID), id);
    }
    
    public Specification<TodoInfoEntity> processEqual(Integer process) {
        return Objects.isNull(process)
               ? null
               : (root, query, builder) -> builder.equal(root.get(TodoInfoEntity.COLUMN_NAME_PROCESS), process);
    }
    
    public Specification<TodoInfoEntity> textContain(String text) {
        return StringUtils.isBlank(text)
               ? null
               : (root, query, builder) -> builder.like(root.get(TodoInfoEntity.COLUMN_NAME_TEXT), "%" + text + "%");
    }
    
    public Specification<TodoInfoEntity> createAtGreaterThanEqual(LocalDate begin) {
        return Objects.isNull(begin)
               ? null
               : (root, query, builder) -> builder.greaterThanOrEqualTo(root.get(TodoInfoEntity.COLUMN_NAME_CREATE_AT),
                   begin
               );
    }
    
    public Specification<TodoInfoEntity> createAtLessThanEqual(LocalDate end) {
        return Objects.isNull(end)
               ? null
               : (root, query, builder) -> builder.lessThanOrEqualTo(root.get(TodoInfoEntity.COLUMN_NAME_CREATE_AT),
                   end
               );
    }
    
    public Specification<TodoInfoEntity> updateAtGreaterThanEqual(LocalDate begin) {
        return Objects.isNull(begin)
               ? null
               : (root, query, builder) -> builder.greaterThanOrEqualTo(root.get(TodoInfoEntity.COLUMN_NAME_UPDATE_AT),
                   begin
               );
    }
    
    public Specification<TodoInfoEntity> updateAtLessThanEqual(LocalDate end) {
        return Objects.isNull(end)
               ? null
               : (root, query, builder) -> builder.lessThanOrEqualTo(root.get(TodoInfoEntity.COLUMN_NAME_UPDATE_AT),
                   end
               );
    }
    
    public Specification<TodoInfoEntity> createAtBetween(LocalDate begin, LocalDate end) {
        return Objects.isNull(begin) || Objects.isNull(end)
               ? null
               : (root, query, builder) -> builder.between(root.get(TodoInfoEntity.COLUMN_NAME_CREATE_AT), begin, end);
    }
    
    public Specification<TodoInfoEntity> updateAtBetween(LocalDate begin, LocalDate end) {
        return Objects.isNull(begin) || Objects.isNull(end)
               ? null
               : (root, query, builder) -> builder.between(root.get(TodoInfoEntity.COLUMN_NAME_UPDATE_AT), begin, end);
    }
}