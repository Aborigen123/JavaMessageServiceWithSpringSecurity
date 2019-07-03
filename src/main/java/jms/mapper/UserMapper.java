package jms.mapper;


import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import jms.domain.ResetPassword;
import jms.domain.UserRegistrationRequest;
import jms.entity.UserEntity;
import jms.entity.enumeration.Role;


public interface UserMapper {

	public static User toSecurityUser(UserEntity userEntity) {
		return new User(userEntity.getEmail(),userEntity.getPassword(), AuthorityUtils.createAuthorityList(String.valueOf(userEntity.getRole())));
	}
	
	
	public static UserEntity registerToUser(UserRegistrationRequest userRegistrationRequest) {
		UserEntity customer = new UserEntity();
		customer.setNameUser(userRegistrationRequest.getNameCustomer());
		customer.setEmail(userRegistrationRequest.getEmail());
		customer.setPassword(userRegistrationRequest.getPassword());
		customer.setRole(Role.ROLE_USER);
return customer;
	}
	
	public static UserEntity registerToEmployee(UserRegistrationRequest userRegistrationRequest) {
		UserEntity customer = new UserEntity();
		customer.setNameUser(userRegistrationRequest.getNameCustomer());
		customer.setEmail(userRegistrationRequest.getEmail());
		customer.setPassword(userRegistrationRequest.getPassword());
		customer.setActivated(true);
		customer.setRole(userRegistrationRequest.getRole());
return customer;
	}
	
	public static UserEntity resetPassword(ResetPassword resetPassword) {
		UserEntity customer = new UserEntity();
		customer.setPassword(resetPassword.getPassword());
return customer;
}
}