package com.application.Service;

import org.springframework.stereotype.Service;

import com.application.Entity.UserCredentials;

@Service
public interface LoginService {
	
	String GetUserByEmailId(String emailId, String password);
	UserCredentials GetUserByUserId(int UserId);
}
