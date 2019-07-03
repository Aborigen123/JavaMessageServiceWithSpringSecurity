package jms.validator.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import jms.validator.validator.UniquePhoneNumberValidator;




@Target(value = { ElementType.FIELD, ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniquePhoneNumberValidator.class)
public @interface UniquePhoneNumber {
	String message() default "This user exist";
	Class<?>[] groups() default{};
	Class<? extends Payload>[] payload() default {};
}
