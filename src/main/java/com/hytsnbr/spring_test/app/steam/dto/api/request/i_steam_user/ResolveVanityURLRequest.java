package com.hytsnbr.spring_test.app.steam.dto.api.request.i_steam_user;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hytsnbr.spring_test.app.steam.dto.api.request.BaseRequest;
import com.hytsnbr.spring_test.base_common.config.property.ApiKey;

@Getter
@Setter
public class ResolveVanityURLRequest extends BaseRequest {
    
    @JsonProperty("vanityurl")
    private String userName;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("url_type")
    private Integer urlType;
    
    /**
     * コンストラクタ
     */
    public ResolveVanityURLRequest(ApiKey apiKey) {
        super(apiKey);
    }
}