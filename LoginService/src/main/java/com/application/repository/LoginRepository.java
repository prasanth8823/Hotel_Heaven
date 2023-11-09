package com.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.application.Entity.UserCredentials;
import java.util.Optional;

@Component
public interface LoginRepository extends JpaRepository<UserCredentials, Integer> {
	Optional<UserCredentials> findByEmailId(String emailId);
	Optional<UserCredentials> findByPhoneNumber(long phoneNumber);
}
