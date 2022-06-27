package com.hytsnbr.demo.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.hytsnbr.demo.validator.MaxDigits.List;
import com.hytsnbr.demo.validator.impl.MaxDigitsValidator;

/**
 * 正の整数（自然数）の桁数バリデーター
 */
@Documented
@Constraint(validatedBy = { MaxDigitsValidator.class })
@Target({
        ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR,
        ElementType.PARAMETER, ElementType.TYPE_USE
})
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
    })
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        MaxDigits[] value();
    }
}