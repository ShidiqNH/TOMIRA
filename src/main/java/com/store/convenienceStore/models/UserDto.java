package com.store.convenienceStore.models;


import jakarta.validation.constraints.*;

public class UserDto {
	private Long id; // Assuming there's an ID field

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@NotEmpty(message = "The username is required")
	private String username;
	
	@NotEmpty(message = "The fullname is required")
	private String fullname;
	
	@NotEmpty(message = "The password is required")
	private String password;
	
	private String level;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}	
	
}