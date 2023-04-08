package com.hytsnbr.steam_tool.constant;

import org.apache.commons.lang3.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DataType {
    UINT64(Long.class.getSimpleName(), "uint64"),
    UINT32(Integer.class.getSimpleName(), "uint32"),
    INT32(Integer.class.getSimpleName(), "int32"),
    STRING(String.class.getSimpleName(), "string"),
    BOOL(Boolean.class.getSimpleName(), "bool"),
    RAW_BINARY(Byte.class.getSimpleName(), "rawbinary"),
    OBJECT(Object.class.getSimpleName(), null);
    
    private final String className;
    
    private final String steamApiDateTypeName;
    
    public static DataType toEnum(String steamApiDateTypeName) {
        for (DataType dataType : DataType.values()) {
            if (StringUtils.equals(dataType.getSteamApiDateTypeName(), steamApiDateTypeName)) {
                return dataType;
            }
        }
        
        return DataType.OBJECT;
    }
}
