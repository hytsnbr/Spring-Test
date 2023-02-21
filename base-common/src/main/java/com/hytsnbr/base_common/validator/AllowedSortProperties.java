package com.hytsnbr.base_common.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.hytsnbr.base_common.validator.AllowedSortProperties.List;
import com.hytsnbr.base_common.validator.impl.AllowedSortPropertiesValidator;

/**
 * Pageable に対するソート対象プロパティバリデーター
 * 参考: https://qiita.com/kazuki43zoo/items/dc159e7e4607037ff90a
 */
@Documented
@Constraint(validatedBy = { AllowedSortPropertiesValidator.class })
@Target({ ElementType.ANNOTATION_TYPE, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(List.class)
public @interface AllowedSortProperties {
    
    /**
     * 指定可能なプロパティ
     */
    String[] properties();
    
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
        
        AllowedSortProperties[] value();
    }
}