package com.appsdeveloperblog.app.ws.ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailsRequestModel {
	
	@NotNull(message = "El campo firstName no puede ser nulo")
	private String firstName;
	
	@NotNull(message = "El campo lastName no puede ser nulo")
	private String lastName;
	
	@NotNull(message = "El campo email no puede ser nulo")
	@Email
	private String email;
	
	@NotNull(message = "El campo password no puede ser nulo")
	@Size(min = 8, max = 16, message = "El password debe tener minimo 8 o maximo 16 caracteres")
	private String password;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

}
