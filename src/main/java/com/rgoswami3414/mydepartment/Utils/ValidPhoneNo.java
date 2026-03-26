package com.rgoswami3414.mydepartment.Utils;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidPhoneNo implements ConstraintValidator<PhoneNoValidator,String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) return false;

        return s.matches("^[6-9]\\d{9}$");
    }
}
