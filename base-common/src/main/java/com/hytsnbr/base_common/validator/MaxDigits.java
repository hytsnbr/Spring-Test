package com.hytsnbr.base_common.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.hytsnbr.base_common.validator.MaxDigits.List;
import com.hytsnbr.base_common.validator.impl.MaxDigitsValidator;

/**
 * 正の整数（自然数）の桁数バリデーター
 */
@Documented
@Constraint(validatedBy = {MaxDigitsValidator.class})
@Target({
    ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR,
    ElementType.PARAMETER, ElementType.TYPE_USE
}
)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(List.class)
public @interface MaxDigits {
    
    /**
     * 最大桁数
     */
    int max();
    
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
    @Target({
        ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR,
        ElementType.PARAMETER, ElementType.TYPE_USE
    }
    )
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        
        MaxDigits[] value();
    }
}