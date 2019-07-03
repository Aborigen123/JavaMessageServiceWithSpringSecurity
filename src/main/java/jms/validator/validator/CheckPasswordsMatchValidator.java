package jms.validator.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import jms.domain.UserRegistrationRequest;
import jms.validator.anotation.CheckPasswordsMatch;




@Component
public class CheckPasswordsMatchValidator implements ConstraintValidator<CheckPasswordsMatch, UserRegistrationRequest> {

	@Override
	public void initialize(CheckPasswordsMatch constraintAnnotation) {

	}

	@Override
	public boolean isValid(UserRegistrationRequest user, ConstraintValidatorContext context) {
		
		if(user.getPassword() == null || user.getPasswordConfirmation() == null) {
			return false;
		}
		
		if(user.getPassword().equals(user.getPasswordConfirmation())) {
			return true;
		}
		
		
		return false;
	}
}
