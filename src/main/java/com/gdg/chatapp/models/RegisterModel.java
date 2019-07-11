package com.gdg.chatapp.models;

public class RegisterModel {
	
	private String phone;
	private String name;
	private String password;

	public RegisterModel(String phone, String name, String password) {
		super();
		this.phone = phone;
		this.name = name;
		this.password = password;
	}

	public RegisterModel() {
		super();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
