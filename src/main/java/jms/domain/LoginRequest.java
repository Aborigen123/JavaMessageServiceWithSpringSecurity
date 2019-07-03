package jms.domain;

import org.hibernate.validator.constraints.NotEmpty;

import jms.validator.anotation.CheckisActivated;
@CheckisActivated
public class LoginRequest {

private String email;

	private String password;
	
	private boolean isActivated;

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
public	LoginRequest(){}

public boolean isActivated() {
	return isActivated;
}

public void setActivated(boolean isActivated) {
	this.isActivated = isActivated;
};
	
}
