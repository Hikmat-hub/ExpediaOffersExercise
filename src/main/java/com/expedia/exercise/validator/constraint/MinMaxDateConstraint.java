package com.expedia.exercise.validator.constraint;

import com.expedia.exercise.validator.MinMaxDateValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MinMaxDateValidator.class)
@Target( { ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface MinMaxDateConstraint {
    String minDateParameterName();
    String maxDateParameterName();
    String message() default "Max date should be bigger than Min Date value";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
