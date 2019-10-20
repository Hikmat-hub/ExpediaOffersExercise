package com.expedia.exercise.validator;

import com.expedia.exercise.Util.CalendarUtil;
import com.expedia.exercise.validator.constraint.PresentFutureDateConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Calendar;
import java.util.Date;

/**
 * Date value should equal or grater than current date
 */
public class PresentFutureDateValidator implements ConstraintValidator<PresentFutureDateConstraint, Date> {
    @Override
    public boolean isValid(Date minDateValue, ConstraintValidatorContext context) {
        if(minDateValue == null){
            return true;
        }
        Calendar currentCalendar = CalendarUtil.getClearTimeCalendar(new Date());
        Calendar calendar = CalendarUtil.getClearTimeCalendar(minDateValue);
        return !currentCalendar.after(calendar);
    }
}
