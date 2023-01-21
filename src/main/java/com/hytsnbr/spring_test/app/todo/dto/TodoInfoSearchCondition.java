package com.hytsnbr.spring_test.app.todo.dto;

public record TodoInfoSearchCondition(
    Long id,
    Integer process,
    String text
) {
}
