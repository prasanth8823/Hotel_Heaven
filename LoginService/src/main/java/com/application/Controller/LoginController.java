package com.application.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.application.Entity.UserCredentials;
import com.application.ServiceImplementation.LoginServiceImplementation;

@RestController
public class LoginController {
	
	@Autowired
	LoginServiceImplementation imp;
	
	@GetMapping(value = "/HotelHaven/Login")
	private String loginUserByEmailId(@RequestParam String emailId, String password) {
		String getUserByEmailId = imp.GetUserByEmailId(emailId, password);
		return getUserByEmailId;
	}
	
	@GetMapping(value = "/HotelHaven/Login/Get")
	private UserCredentials getUser(@RequestParam int UserId) {
		UserCredentials getUserByUserId = imp.GetUserByUserId(UserId);
		return getUserByUserId;
	}
}
