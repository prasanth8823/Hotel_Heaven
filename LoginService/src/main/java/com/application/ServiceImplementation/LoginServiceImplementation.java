package com.application.ServiceImplementation;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.application.Entity.UserCredentials;
import com.application.Service.LoginService;
import com.application.repository.LoginRepository;

import jakarta.persistence.EntityNotFoundException;

@Component
public class LoginServiceImplementation implements LoginService {

	@Autowired
	LoginRepository repo;
	@Autowired
	JavaMailSender mailSender;

	@Override
	public String GetUserByEmailId(String emailId, String password) {
		Optional<UserCredentials> findByEmailId = repo.findByEmailId(emailId);
		if (findByEmailId.isPresent() == true) {
			UserCredentials userCredentials = findByEmailId.get();
			if (BCrypt.checkpw(password, userCredentials.getPassword()) == true) {
				return "Wellcome " + userCredentials.getFirstName() + " " + userCredentials.getLastName();
			} else {
				throw new IllegalArgumentException("Incorrect Password:" + "[" + password + "]");
			}
		} else {
			throw new IllegalArgumentException("User not Found:" + "[" + emailId + "]");
		}
	}

	@Override
	public UserCredentials GetUserByUserId(int UserId) {
		Optional<UserCredentials> findById = repo.findById(UserId);
		if (findById.isPresent() == true) {
			UserCredentials userCredentials = findById.get();
			return userCredentials;
		} else {
			throw new EntityNotFoundException("user not found :" + UserId);
		}
	}
}
