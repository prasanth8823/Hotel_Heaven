package com.application.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class UserCredentialsModel {

	private String firstName;
	private String lastName;
	private char gender;
	private LocalDate dateOfBirth;
	private LocalDate currentDate = LocalDate.now();
	private String emailId;
	private long phoneNumber;
	private String password;
	private String conFrimPassword;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {

		for (Character charOffName : firstName.toCharArray()) {
			if (Character.isDigit(charOffName)) {
				throw new IllegalArgumentException("Invalid Name: Name cannot contain digits." + "[" + firstName + "]");
			}
		}
		if (firstName.length() == 1) {
			throw new IllegalArgumentException("Name connot be single letter:" + "[" + firstName + "]");
		}
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {

		for (Character charOffName : lastName.toCharArray()) {
			if (Character.isDigit(charOffName)) {
				throw new IllegalArgumentException("Invalid Name: Name cannot contain digits:" + "[" + lastName + "]");
			}
		}
		if (lastName.length() == 1) {
			throw new IllegalArgumentException("Name connot be single letter:" + "[" + lastName + "]");
		}
		this.lastName = lastName;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		String datePattern = "yyyy-MM-dd";
		DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern(datePattern);

		LocalDate parse = LocalDate.parse(dateOfBirth, ofPattern);
		this.dateOfBirth = parse;
	}

	public LocalDate getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(LocalDate currentDate) {
		this.currentDate = currentDate;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		String regex = "^[A-Za-z0-9+_.-]+@gmail.com$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(emailId);
		boolean matches = matcher.matches();

		if (matches == true) {
			this.emailId = emailId;
		} else {
			throw new IllegalArgumentException("Not valide EmailId:" + emailId);
		}
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		String phNo = String.valueOf(phoneNumber);
		if (phNo.length() == 10 && phNo.chars().allMatch(Character::isDigit)) {
			this.phoneNumber = phoneNumber;
		} else {
			throw new IllegalArgumentException("Invalid phone Number Format:" + phoneNumber);
		}
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConFrimPassword() {
		return conFrimPassword;
	}

	public void setConFrimPassword(String conFrimPassword) {
		this.conFrimPassword = conFrimPassword;
	}
}
