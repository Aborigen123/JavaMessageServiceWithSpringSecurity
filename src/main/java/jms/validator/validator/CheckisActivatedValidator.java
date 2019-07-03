package jms.validator.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jms.domain.LoginRequest;
import jms.entity.UserEntity;
import jms.repostory.UserEntityRepository;
import jms.validator.anotation.CheckisActivated;



@Component
public class CheckisActivatedValidator implements ConstraintValidator<CheckisActivated, LoginRequest> {

	@Autowired private UserEntityRepository userEntityRepository;
	
	@Override
	public void initialize(CheckisActivated constraintAnnotation) {
		
		
	}

	@Override
	public boolean isValid(LoginRequest value, ConstraintValidatorContext context) {

		UserEntity user = userEntityRepository.findUserByEmail(value.getEmail());
	
		if(user.isActivated() != false) {
			return true;
		}

		return false;
	}
}
