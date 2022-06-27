package com.hytsnbr.demo.validator.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

import com.hytsnbr.demo.validator.MaxDigits;

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

        if (Objects.isNull(value)) {
            return true;
        }

        String strValue = String.valueOf(value);
        if (strValue.length() > max) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(message)
                    .addConstraintViolation();

            return false;
        }

        return true;
    }
}