package com.hytsnbr.spring_test.app.steam.dto.api.response;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
public class BaseResponse<T> {
    
    @JsonProperty("response")
    private T response;
}
