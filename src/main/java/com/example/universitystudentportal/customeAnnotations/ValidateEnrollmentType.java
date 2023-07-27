package com.example.universitystudentportal.customeAnnotations;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = EnrollmentValidator.class)
public @interface ValidateEnrollmentType {
    public String message() default  "Invalid TYPE : It should be either BLOCK ,CONVENTIONAL or WEEKEND";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
