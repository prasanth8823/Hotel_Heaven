package com.application.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.ServiceImplementation.SignUpServiceImplementation;
import com.application.model.UserCredentialsModel;

@RestController
public class SignUpController {
	
	@Autowired
	SignUpServiceImplementation imp;
	
	@PostMapping(value = "/HotelHaven/SignUp")
	private String createUserAccount(@RequestBody UserCredentialsModel userFields) {
		String signUpUser = imp.signUpUser(userFields);
		return signUpUser;
	}
}
