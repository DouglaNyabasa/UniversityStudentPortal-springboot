package com.example.universitystudentportal.customeAnnotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class RoleValidator implements ConstraintValidator<ValidateRole,String> {
    @Override
    public boolean isValid(String role, ConstraintValidatorContext constraintValidatorContext) {

        List<String> roles = Arrays.asList("ADMIN","STUDENT","LECTURER");
        return roles.contains(role);
    }
}
