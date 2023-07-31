package com.example.universitystudentportal.customeAnnotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class LeaveTypeValidator implements ConstraintValidator<ValidateLeaveType,String> {
    @Override
    public boolean isValid(String leaveType, ConstraintValidatorContext constraintValidatorContext) {
        List<String> typesOfLeaves = Arrays.asList("UNPAID_LEAVE","VACATION_LEAVE","SICK_LEAVE");
        return typesOfLeaves.contains(leaveType);
    }
}
