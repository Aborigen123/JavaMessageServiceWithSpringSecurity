package jms.validator.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import jms.validator.validator.CheckisActivatedValidator;



@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckisActivatedValidator.class)
public @interface CheckisActivated {
	String message() default "We send a new mail with confirm on your mail";
	Class<?>[] groups() default{};
	Class<? extends Payload>[] payload() default {};
}
