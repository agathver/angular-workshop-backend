package com.gdg.chatapp.security;

public interface UserService {

	public void registerUser(String name,String phone, String password);
	
	public Account getUser(String phone);
	
}
