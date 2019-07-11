package com.gdg.chatapp.security;

import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl implements UserService{
	
	private Map<String,Account> users = new HashMap<>();
	
	@Override
	public void registerUser(String name, String phone, String password) {
		
		if(users.get(phone) !=null) {
			throw new AccountAlreadyExistsException("The phone number is already registered");
		}
		Account account = new Account(phone,name,password);
		this.users.put(phone,account);
	}

	@Override
	public Account getUser(String email) {
		return this.users.get(email);
	}
}
