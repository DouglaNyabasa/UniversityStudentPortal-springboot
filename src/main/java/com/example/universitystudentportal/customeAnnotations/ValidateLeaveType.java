package com.example.universitystudentportal.customeAnnotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = LeaveTypeValidator.class)
public @interface ValidateLeaveType {
    public String message() default "Invalid Leave Type: It should be either UNPAID_LEAVE ,VACATION_LEAVE or SICK_LEAVE";


    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
