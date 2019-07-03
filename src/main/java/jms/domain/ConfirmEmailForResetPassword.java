package jms.domain;

import org.hibernate.validator.constraints.NotEmpty;

import jms.validator.anotation.CheckEmail;

public class ConfirmEmailForResetPassword {
 
@NotEmpty(message = "can't be empty")
@CheckEmail
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ConfirmEmailForResetPassword() {	}
	
	
}
