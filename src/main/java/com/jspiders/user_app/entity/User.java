package com.jspiders.user_app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data; 

@Entity
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
//	@NotNull(message="name cannot be null")
//	@NotEmpty(message="name cannot be Empty")
	@NotBlank(message = "field does not contain empty, null")
	@Size(min=3, max=5)
	@Pattern(regexp="^[A-Za-z]*$")
	private String userName;
	
	@Email
	private String userEmail;
	private String userPassword;
	private String userContact;
	private String userAddress;
	
}
