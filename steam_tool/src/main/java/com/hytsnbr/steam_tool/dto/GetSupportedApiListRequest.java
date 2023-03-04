package com.hytsnbr.steam_tool.dto;

import lombok.Builder;
import lombok.Getter;

import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Builder
public class GetSupportedApiListRequest {
    
    @JsonProperty("key")
    private String key;
}
