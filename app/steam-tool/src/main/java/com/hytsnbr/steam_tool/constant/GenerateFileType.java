package com.hytsnbr.steam_tool.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GenerateFileType {
    
    REQUEST("request", "request.vm"),
    INTERFACE("interface", "interface.vm"),
    URL("url", "url.vm"),
    ;
    
    private final String generateDirName;
    
    private final String templateName;
}