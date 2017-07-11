package com.servlet;

public class UserData {
	private String user;

	public UserData(String user, String pass) {

		this.user = user;
		this.pass = pass;
	}

	private String pass;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
