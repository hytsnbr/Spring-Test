package com.hytsnbr.demo.steam.model.api;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class BaseResponse {

    @JsonProperty("response")
    private Response response;

    @Data
    public class Response {

        private List<?> objects;
        private Object object;
    }
}
