package jms.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import jms.entity.enumeration.Role;

import lombok.ToString;

@Entity
@Table(name="user")
public class UserEntity extends BaseEntity{

	private String email;
	
	@Column(name = "name_user")
	private String nameUser;
	
	private String password;
	
	private Role role;
	
	  @Column(name = "balance",columnDefinition = "DECIMAL(15,2)")
		private BigDecimal balance;

	  private String token;
	  
	  @Column(name = "is_activated")
	  private boolean isActivated;
	  
	  private String passwordConfirnation;

	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserEntity(String email, String nameUser, String password, Role role, BigDecimal balance, String token,
			boolean isActivated, String passwordConfirnation) {
		super();
		this.email = email;
		this.nameUser = nameUser;
		this.password = password;
		this.role = role;
		this.balance = balance;
		this.token = token;
		this.isActivated = isActivated;
		this.passwordConfirnation = passwordConfirnation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public boolean isActivated() {
		return isActivated;
	}

	public void setActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}

	public String getPasswordConfirnation() {
		return passwordConfirnation;
	}

	public void setPasswordConfirnation(String passwordConfirnation) {
		this.passwordConfirnation = passwordConfirnation;
	}
	
}