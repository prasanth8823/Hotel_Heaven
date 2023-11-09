package com.application.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.application.Entity.Hotel;
import com.application.Models.HotelModel;

@Service
public interface HotelManagementService {
	
	Hotel modifyHotel(HotelModel fields) throws Exception;
	String createHotel(HotelModel fields) throws Exception;
	Hotel retrieveHotel(int hotelId) throws Exception;
	String removeHotel(int hotelId) throws Exception;
	List<Hotel> retrieveALLHotel();
}
