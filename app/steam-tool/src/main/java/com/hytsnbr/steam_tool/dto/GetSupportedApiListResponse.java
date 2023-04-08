package com.hytsnbr.steam_tool.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hytsnbr.steam_tool.dto.GetSupportedApiListResponse.ApiList.Interface;

@Data
public class GetSupportedApiListResponse {
    
    @JsonProperty("apilist")
    private ApiList apiList;
    
    public List<Interface> getApiInterfaceList() {
        if (Objects.isNull(apiList) || Objects.isNull(apiList.interfaces)) {
            return List.of();
        }
        
        return this.apiList.interfaces;
    }
    
    @Data
    public static class ApiList {
        
        @JsonProperty("interfaces")
        private ArrayList<Interface> interfaces;
        
        @Data
        public static class Interface {
            
            @JsonProperty("name")
            private String name;
            
            @JsonProperty("methods")
            private ArrayList<Method> methods;
            
            @Data
            public static class Method {
                
                @JsonProperty("name")
                private String name;
                
                @JsonProperty("version")
                private int version;
                
                @JsonProperty("httpmethod")
                private String httpMethod;
                
                @JsonProperty("parameters")
                private ArrayList<Parameter> parameters;
                
                @Data
                public static class Parameter {
                    
                    @JsonProperty("name")
                    private String name;
                    
                    @JsonProperty("type")
                    private String type;
                    
                    @JsonProperty("optional")
                    private boolean optional;
                    
                    @JsonProperty("description")
                    private String description;
                }
            }
        }
    }
}