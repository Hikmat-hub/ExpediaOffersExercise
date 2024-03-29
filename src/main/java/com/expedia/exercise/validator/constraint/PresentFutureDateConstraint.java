package com.expedia.exercise.validator.constraint;

import com.expedia.exercise.validator.PresentFutureDateValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PresentFutureDateValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PresentFutureDateConstraint {
    String message() default "{PresentFutureDateConstraint}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
