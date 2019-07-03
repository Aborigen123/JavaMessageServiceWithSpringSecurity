package jms.domain;

import org.hibernate.validator.constraints.NotEmpty;

import jms.entity.enumeration.Role;
import jms.validator.anotation.CheckPasswordsMatch;
import jms.validator.anotation.UniquePhoneNumber;




@CheckPasswordsMatch
public class UserRegistrationRequest {
	
	@NotEmpty(message = "can't be empty")
	private String nameCustomer;
	@NotEmpty(message = "can't be empty")
	@UniquePhoneNumber
	private String email;
	@NotEmpty(message = "can't be empty")
	private String password;
	@NotEmpty(message = "can't be empty")
	private String passwordConfirmation;
	private Role role;
	





	public String getNameCustomer() {
		return nameCustomer;
	}






	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}






	public String getEmail() {
		return email;
	}






	public void setEmail(String email) {
		this.email = email;
	}






	public String getPassword() {
		return password;
	}






	public void setPassword(String password) {
		this.password = password;
	}






	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}






	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}






	public Role getRole() {
		return role;
	}






	public void setRole(Role role) {
		this.role = role;
	}






	public UserRegistrationRequest() {}
}
