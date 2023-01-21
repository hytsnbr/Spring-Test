package com.hytsnbr.spring_test.app.todo.dto;

public record TodoInfoRequest(
    long id,
    Integer process,
    String text
) {
    
}
