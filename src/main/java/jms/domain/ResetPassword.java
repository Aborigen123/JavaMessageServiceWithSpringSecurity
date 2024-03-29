package jms.domain;

import jms.validator.anotation.CheckPasswordsMatchForResetPassword;

@CheckPasswordsMatchForResetPassword
public class ResetPassword {

	private String password;
	
	private String passwordConfirmation;


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


	public ResetPassword() {

	}
	
	
}
