package com.hytsnbr.spring_test.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

import com.hytsnbr.spring_test.validator.MaxDigits.List;
import com.hytsnbr.spring_test.validator.impl.MaxDigitsValidator;

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