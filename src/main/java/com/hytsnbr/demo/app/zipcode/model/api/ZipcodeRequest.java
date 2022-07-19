package com.hytsnbr.demo.app.zipcode.model.api;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.hytsnbr.demo.constant.RegexPattern;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ZipcodeRequest {

    @NotNull
    @Pattern(regexp = RegexPattern.ZIPCODE)
    String zipcode;

    @Builder.Default
    int limit = 20; // API側で定めているデフォルト値
}
