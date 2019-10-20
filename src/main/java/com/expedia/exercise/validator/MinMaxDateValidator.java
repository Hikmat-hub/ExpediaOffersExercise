package com.expedia.exercise.validator;

import com.expedia.exercise.Util.CalendarUtil;
import com.expedia.exercise.validator.constraint.MinMaxDateConstraint;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Calendar;
import java.util.Date;

public class MinMaxDateValidator implements ConstraintValidator<MinMaxDateConstraint, Object> {

    private static final SpelExpressionParser PARSER = new SpelExpressionParser();
    private MinMaxDateConstraint constraintAnnotation;

    @Override
    public void initialize(final MinMaxDateConstraint constraintAnnotation) {
        this.constraintAnnotation = constraintAnnotation;
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        final Date maxDateValue = PARSER.parseExpression(this.constraintAnnotation.maxDateParameterName()).getValue(value, Date.class);
        if(maxDateValue == null){
            return true;
        }
        final Date minDateValue = PARSER.parseExpression(this.constraintAnnotation.minDateParameterName()).getValue(value, Date.class);
        if(minDateValue == null){
            return true;
        }

        final Calendar maxDateCalendar = CalendarUtil.getClearTimeCalendar(maxDateValue);
        final Calendar minDateCalendar = CalendarUtil.getClearTimeCalendar(maxDateValue);

        return minDateCalendar.before(maxDateCalendar);
    }
}
