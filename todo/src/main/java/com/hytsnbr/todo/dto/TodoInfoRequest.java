package com.hytsnbr.todo.dto;

import jakarta.validation.constraints.NotNull;

public record TodoInfoRequest(
    long id,
    @NotNull
    Integer process,
    String text
) {
    
}
