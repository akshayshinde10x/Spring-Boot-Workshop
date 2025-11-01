package com.cognatech.dto;

public class RegisterDTO {
    
	private String email;
    private String password;
    private String fullName;
    private String role;

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
    
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
    
    
}