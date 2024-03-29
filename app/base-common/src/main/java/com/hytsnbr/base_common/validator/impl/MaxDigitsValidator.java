package com.hytsnbr.base_common.validator.impl;

import java.util.Objects;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import com.hytsnbr.base_common.util.Util;
import com.hytsnbr.base_common.validator.MaxDigits;

/**
 * 正の整数（自然数）の桁数バリデーター 実装クラス
 */
public class MaxDigitsValidator implements ConstraintValidator<MaxDigits, Integer> {
    
    private int max;
    
    private String message;
    
    @Override
    public void initialize(MaxDigits constraintAnnotation) {
        this.max = constraintAnnotation.max();
        this.message = constraintAnnotation.message();
    }
    
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        
        // Nullは評価外
        if (Objects.isNull(value)) {
            return true;
        }
        
        if (Util.getDigits(value) > max) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(message)
                   .addConstraintViolation();
            
            return false;
        }
        
        return true;
    }
}