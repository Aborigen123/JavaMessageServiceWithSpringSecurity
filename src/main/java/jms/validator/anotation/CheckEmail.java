package jms.validator.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import jms.validator.validator.CheckEmailValidator;





@Target(value = { ElementType.FIELD, ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckEmailValidator.class)
public @interface CheckEmail {
	String message() default "This email dont exist";
	Class<?>[] groups() default{};
	Class<? extends Payload>[] payload() default {};
}
