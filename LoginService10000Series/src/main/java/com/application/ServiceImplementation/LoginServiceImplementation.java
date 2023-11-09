package com.application.ServiceImplementation;

import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
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
		if(findByEmailId.isPresent() == true) {
			UserCredentials userCredentials = findByEmailId.get();
			if(BCrypt.checkpw(password, userCredentials.getPassword()) == true){
				boolean otpGenerator = otpGenerator(emailId);
				if(otpGenerator) {
					return "Wellcome "  + userCredentials.getFirstName() + " " + userCredentials.getLastName();
				}else {
					throw new IllegalArgumentException("Invalide otp");
				}
			}else {
				throw new IllegalArgumentException("Incorrect Password:" + "[" + password + "]");
			}
		}else {
			throw new IllegalArgumentException("User not Found:"+ "["+ emailId + "]");
		}
	}
	
	private boolean otpGenerator(String emailId) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		Random random = new Random();
		try (Scanner input = new Scanner(System.in)) {
			int OTP = random.nextInt();
			mailMessage.setTo(emailId);
			mailMessage.setSubject("Login verification OTP");
			mailMessage.setText("this is your otp: "+ OTP + "don't share this to anyone");
			mailSender.send(mailMessage);
			
			System.out.println("enter otp:");
			int otp = input.nextInt();
			
			if(OTP == otp) {
				return true;
			}
		} catch (MailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public UserCredentials GetUserByUserId(int UserId) {
		Optional<UserCredentials> findById = repo.findById(UserId);
		if(findById.isPresent() == true) {
			UserCredentials userCredentials = findById.get();
			return userCredentials;
		}else {
			throw new EntityNotFoundException("user not found :" + UserId);
		}
	}
}
