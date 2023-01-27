package com.hytsnbr.spring_test.app.steam.dto.api.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hytsnbr.spring_test.base_common.config.property.ApiKey;

public class BaseRequest {
    
    @JsonIgnore
    private final ApiKey apiKey;
    
    public BaseRequest(ApiKey apiKey) {
        this.apiKey = apiKey;
    }
    
    @JsonProperty("key")
    public String getKey() {
        return this.apiKey.getSteam();
    }
    
    /**
     * Boolean to String Binary
     *
     * @param value bool value
     *
     * @return "1" or "0"
     */
    protected String bool2StrBin(boolean value) {
        return value ? "1" : "0";
    }
    
    /**
     * Boolean to Integer Binary
     *
     * @param value bool value
     *
     * @return 1 or 0
     */
    protected int bool2IntBin(boolean value) {
        return value ? 1 : 0;
    }
}