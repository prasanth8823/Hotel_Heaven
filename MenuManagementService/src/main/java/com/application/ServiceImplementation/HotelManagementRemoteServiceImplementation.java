package com.application.ServiceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.application.Model.HotelModel;
import com.application.Service.HotelManagementRemoteService;


@Component
public class HotelManagementRemoteServiceImplementation implements HotelManagementRemoteService {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public HotelModel getHotelDetails(int hotelId) {
		String url = "http://localhost:20004/HavenHotel/Hotel/retrieve?hotelId="+hotelId;
		ResponseEntity<HotelModel> exchange = restTemplate.exchange(url, HttpMethod.GET, null, HotelModel.class);
		HotelModel body = exchange.getBody();
		return body;
	}

}
