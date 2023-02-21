package com.hytsnbr.base_common.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.hytsnbr.base_common.validator.PagerSizeLimit.List;
import com.hytsnbr.base_common.validator.impl.PagerSizeLimitValidator;

/**
 * Pageable に対するページサイズ限界値バリデーター
 */
@Documented
@Constraint(validatedBy = { PagerSizeLimitValidator.class })
@Target({ ElementType.ANNOTATION_TYPE, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(List.class)
public @interface PagerSizeLimit {
    
    /**
     * ページサイズ上限値
     */
    int max();
    
    /**
     * ページサイズ下限値
     */
    int min() default 0;
    
    /**
     * バリデーションエラー時のメッセージ
     */
    String message() default ""; // TODO: 設定する
    
    /**
     * バリデーショングループ
     */
    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default {};
    
    @Documented
    @Target({ ElementType.ANNOTATION_TYPE, ElementType.PARAMETER })
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        
        PagerSizeLimit[] value();
    }
}