package com.hytsnbr.zipcode.dto.api;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
public class ZipcodeResponse {
    
    @JsonProperty("status")
    int status;
    
    @JsonProperty("massage")
    String massage;
    
    @JsonProperty("results")
    List<Result> results;
    
    @Getter
    @Setter
    @NoArgsConstructor
    public static class Result {
        
        @JsonProperty("zipcode")
        String zipcode;
        
        @JsonProperty("prefcode")
        String prefCode;
        
        @JsonProperty("address1")
        String address1;
        
        @JsonProperty("address2")
        String address2;
        
        @JsonProperty("address3")
        String address3;
        
        @JsonProperty("kana1")
        String kana1;
        
        @JsonProperty("kana2")
        String kana2;
        
        @JsonProperty("kana3")
        String kana3;
        
        public String getAddress() {
            return address1 + address2 + address3 + kana1 + kana2 + kana3;
        }
    }
}
