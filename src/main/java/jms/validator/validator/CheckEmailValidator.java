package jms.validator.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jms.service.UserEntityService;
import jms.validator.anotation.CheckEmail;


@Component
public class CheckEmailValidator implements ConstraintValidator<CheckEmail,String> {

	@Autowired private UserEntityService userEntityService;
	@Override
	public void initialize(CheckEmail constraintAnnotation) {
	
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value== null) { 
			return false;
		}
		if(userEntityService.findUserByEmailUnique(value) != null) {
			return true;
		}else {
			return false;
		}
	}

}
