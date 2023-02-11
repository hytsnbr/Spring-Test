package com.hytsnbr.dto;

import java.sql.Timestamp;

public record TodoInfoResponse(
    long id,
    Integer process,
    String text,
    Timestamp createAt,
    Timestamp updateAt
) {
    
}
