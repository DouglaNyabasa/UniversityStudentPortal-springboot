package com.example.universitystudentportal.customeAnnotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = RoleValidator.class)
public @interface ValidateRole {

    public String message() default "Invalid Role Please Try Again : It should be either ADMIN ,STUDENT or LECTURER ";


    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
