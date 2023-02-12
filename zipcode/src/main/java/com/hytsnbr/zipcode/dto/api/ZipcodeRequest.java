package com.hytsnbr.zipcode.dto.api;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;

import com.hytsnbr.base_common.constant.RegexPattern;

@Getter
@Builder
public class ZipcodeRequest {
    
    @NotNull
    @Pattern(regexp = RegexPattern.ZIPCODE)
    String zipcode;
    
    @Builder.Default
    int limit = 20; // API側で定めているデフォルト値
}
