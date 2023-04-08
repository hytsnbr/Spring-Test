package com.hytsnbr.base_common.validator.impl;

import java.util.Objects;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import org.springframework.data.domain.Pageable;

import com.hytsnbr.base_common.validator.PagerSizeLimit;

/**
 * Pageable に対するページサイズ限界値バリデーター 実装クラス
 */
public class PagerSizeLimitValidator implements ConstraintValidator<PagerSizeLimit, Pageable> {
    
    private int max;
    
    private int min;
    
    private String message;
    
    @Override
    public void initialize(PagerSizeLimit constraintAnnotation) {
        this.max = constraintAnnotation.max();
        this.min = constraintAnnotation.min();
        this.message = constraintAnnotation.message();
    }
    
    @Override
    public boolean isValid(Pageable pageable, ConstraintValidatorContext context) {
        
        // Null は評価外
        if (Objects.isNull(pageable)) {
            return true;
        }
        
        return pageable.getPageSize() <= max && pageable.getPageSize() >= min;
    }
}