package com.application.Service;

import org.springframework.stereotype.Service;

import com.application.Model.HotelModel;

@Service
public interface HotelManagementRemoteService {
	
	
	HotelModel getHotelDetails(int hotelId);
}
