package com.gopal.exception;

public class UserAlreadyPresent extends Exception{

	private String string;

	public UserAlreadyPresent(String string) {
		super();
		this.string = string;
		
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	@Override
	public String toString() {
		return "UserAlreadyPresent [string=" + string + "]";
	}
    
}
