package com.gopal.exception;

public class UserNotAvailable extends Exception{
	
	public String string;

	public UserNotAvailable(String string) {
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
		return "UserNotAvailable [string=" + string + "]";
	}
	

}
