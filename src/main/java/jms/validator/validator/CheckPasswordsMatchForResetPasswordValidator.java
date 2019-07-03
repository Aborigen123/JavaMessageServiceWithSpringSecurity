package jms.validator.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import jms.domain.ResetPassword;
import jms.validator.anotation.CheckPasswordsMatchForResetPassword;


@Component
public class CheckPasswordsMatchForResetPasswordValidator implements ConstraintValidator<CheckPasswordsMatchForResetPassword,ResetPassword>{

	@Override
	public void initialize(CheckPasswordsMatchForResetPassword constraintAnnotation) {
		
		
	}

	@Override
	public boolean isValid(ResetPassword value, ConstraintValidatorContext context) {
		
		if(value.getPassword() == null || value.getPasswordConfirmation() == null) {
			return false;
		}
		
		if(value.getPassword().equals(value.getPasswordConfirmation())) {
			return true;
		}
		
		
		return false;
	}
}
