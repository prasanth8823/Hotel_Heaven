package com.application.Service;

import org.springframework.stereotype.Service;

import com.application.model.UserCredentialsModel;

@Service
public interface SignUpService {
	
	String signUpUser(UserCredentialsModel userFields);
}
