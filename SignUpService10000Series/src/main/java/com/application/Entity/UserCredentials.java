package com.application.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.annotations.CreationTimestamp;
import org.mindrot.jbcrypt.BCrypt;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class UserCredentials {

	@Id
	@GeneratedValue(generator = "User_Credentials_Generator", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "User_Credentials_Generator", sequenceName = "User_Credentials_Sequence", initialValue = 100, allocationSize = 1)
	private int UserId;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@Column(nullable = false)
	private char gender;
	
	@Column(nullable = false)
	private LocalDate dateOfBirth;
	
	@Column (nullable = false)
	private int age;
	
	@Column(nullable = false, unique = true)
	private String emailId;

	@Column(nullable = false, unique = true)
	private long phoneNumber;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private String salt = BCrypt.gensalt();

	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	private LocalDateTime createdAt;

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
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

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getAge() {
		return age;
	}

	public void setAge(LocalDate currentDate) {
		Period between = Period.between(dateOfBirth, currentDate);
		int years = between.getYears();
		this.age = years;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if (password.length() >= 8) {
			String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\",./<>?])(?=\\S+$).{8,}$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(password);
			boolean matches = matcher.matches();
			if (matches == true) {
				String hashpw = BCrypt.hashpw(password,salt);
				this.password = hashpw;
			}
		} else {
			throw new IllegalArgumentException(
					"The Password Length Should More Than Eight Characters, Uppercase, Lowercase, NumericValue And SpecialCharacters");
		}
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
}
