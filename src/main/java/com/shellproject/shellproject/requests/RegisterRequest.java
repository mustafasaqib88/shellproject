package com.shellproject.shellproject.requests;

import java.io.Serializable;

public class RegisterRequest implements Serializable{

    private static final long serialVersionUID = 5926468583005150707L;
	
	private String username;
	private String password;
	private String email;
	
	//need default constructor for JSON Parsing
	public RegisterRequest()
	{
		
	}

	public RegisterRequest(String username, String password, String email) {
		this.setUsername(username);
		this.setPassword(password);
		this.setEmail(email);
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail(){
		return this.email;
	}

	public void setEmail(String email){
		this.email=email;
	}
    
}
