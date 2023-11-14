package com.application.ServiceImplementation;

import java.util.Optional;

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
			repo.save(credentials);
			mailGenerator(userFields.getEmailId());
			return "Account Created Successfully";

		}
	}

	private void mailGenerator(String emailid) {
		String companyName = "HOTELHEAVEN";
		String companyEmail = "deepaprasanth2206gmail.com";
		long phNomber = 7358188823l;

		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(emailid);
		mailMessage.setSubject("Account Created Successfully");
		mailMessage.setText(
				"We are pleased to inform you that your account has been successfully created. This marks the beginning of your journey with "
						+ companyName
						+ ", and we're excited to have you on board\n\n\n\nPlease keep your login credentials confidential and do not share them with anyone. If you encounter any issues during the login process or have any questions, please don't hesitate to contact our support team at "
						+ companyEmail + " or " + phNomber
						+ ".\n\n\nWe look forward to providing you with a seamless and rewarding experience with "
						+ companyName
						+ ". Thank you for choosing us, and welcome to our community!\n\n\n\nBest regards,\n\n\nCompany Name: "
						+ companyName + "\nCompany EmailId: " + companyEmail + "\nCompany PhoneNumber: " + phNomber);
		mailSender.send(mailMessage);
	}
}
