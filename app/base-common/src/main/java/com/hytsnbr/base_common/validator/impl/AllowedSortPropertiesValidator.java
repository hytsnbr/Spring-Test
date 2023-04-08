package com.hytsnbr.base_common.validator.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.hytsnbr.base_common.validator.AllowedSortProperties;

/**
 * Pageable に対するソート対象プロパティバリデーター 実装クラス
 */
public class AllowedSortPropertiesValidator implements ConstraintValidator<AllowedSortProperties, Pageable> {
    
    private Set<String> properties;
    
    private String message;
    
    @Override
    public void initialize(AllowedSortProperties constraintAnnotation) {
        this.properties = new HashSet<>(List.of(constraintAnnotation.properties()));
        this.message = constraintAnnotation.message();
    }
    
    @Override
    public boolean isValid(Pageable value, ConstraintValidatorContext context) {
        
        // Null, ソート未指定は評価外
        if (Objects.isNull(value)) {
            return true;
        }
        
        // propertiesの空チェック
        if (properties.isEmpty()) {
            return true;
        }
        
        for (Sort.Order order : value.getSort()) {
            if (!properties.contains(order.getProperty())) {
                return false;
            }
        }
        
        return true;
    }
}