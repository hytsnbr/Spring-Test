package com.hytsnbr.spring_test.app.todo.dto;

import java.sql.Timestamp;

public record TodoInfoResponse(
    long id,
    Integer process,
    String text,
    Timestamp createAt,
    Timestamp updateAt
) {
    
}
