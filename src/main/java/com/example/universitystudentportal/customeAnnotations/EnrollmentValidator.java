package com.example.universitystudentportal.customeAnnotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class EnrollmentValidator implements ConstraintValidator<ValidateEnrollmentType,String> {
    @Override
    public boolean isValid(String enrollment, ConstraintValidatorContext constraintValidatorContext) {
        List<String> enrollementTypes = Arrays.asList("CONVENTIONAL","BLOCK","WEEKEND");
        return enrollementTypes.contains(enrollment);
    }
}
