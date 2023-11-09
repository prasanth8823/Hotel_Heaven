package com.application.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.application.Entity.Hotel;


@Component
public interface HotelManagementRepository extends JpaRepository<Hotel, Integer> {

	Optional<Hotel> findByHotelName(String hotelName);

	Hotel getByHotelId(int hotelId);
}
