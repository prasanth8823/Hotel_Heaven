package com.application.ServiceImplementation;

import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.application.Entity.UserCredentials;
import com.application.Repository.SignUpRepository;
import com.application.Service.SignUpService;
import com.application.model.UserCredentialsModel;

@Component
public class SignUpServiceImplementation implements SignUpService {

	@Autowired
	SignUpRepository repo;
	@Autowired
	JavaMailSender mailSender;

	@Override
	public String signUpUser(UserCredentialsModel userFields) {

		Optional<UserCredentials> findByEmailId = repo.findByEmailId(userFields.getEmailId());
		Optional<UserCredentials> findByPhoneNumber = repo.findByPhoneNumber(userFields.getPhoneNumber());

		if (findByEmailId.isPresent() || findByPhoneNumber.isPresent()) {
			throw new IllegalIdentifierException("user already exists");
		} else if (!userFields.getPassword().equals(userFields.getConFrimPassword())) {
			throw new IllegalArgumentException(
					"Password Mismatch" + "[" + userFields.getPassword() + "," + userFields.getConFrimPassword() + "]");
		} else {
			UserCredentials credentials = new UserCredentials();
			credentials.setFirstName(userFields.getFirstName());
			credentials.setLastName(userFields.getLastName());
			credentials.setEmailId(userFields.getEmailId());
			credentials.setGender(userFields.getGender());
			credentials.setDateOfBirth(userFields.getDateOfBirth());
			credentials.setAge(userFields.getCurrentDate());
			credentials.setPassword(userFields.getPassword());
			credentials.setPhoneNumber(userFields.getPhoneNumber());
			boolean otpGenerator = otpGenerator(userFields.getEmailId());
			if (otpGenerator) {
				repo.save(credentials);
				return "signuped successfully";
			} else {
				throw new IllegalArgumentException("invalid otp");
			}
		}
	}

	private boolean otpGenerator(String emailid) {

		SimpleMailMessage mailMessage = new SimpleMailMessage();
		Random random = new Random();
		try (Scanner input = new Scanner(System.in)) {
			int OTP = random.nextInt(10000) + 1;
			mailMessage.setTo(emailid);
			mailMessage.setSubject("Signup verification OTP");
			mailMessage.setText("your OTP is :" + OTP + "don't share this to anyone");
			mailSender.send(mailMessage);
			try {
				Thread.sleep(1000); // Sleep for 1 second (1000 milliseconds)
			} catch (InterruptedException e) {
				e.getMessage();
			}
			System.out.println("enter OTP:");
			int otp = input.nextInt();
			if (OTP == otp) {
				return true;
			} else {
				return false;
			}
		}
	}

}
