package com.application.serviceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.application.Model.OrderHotelModel;
import com.application.Model.OrderMenuModel;
import com.application.Model.OrderUserModel;
import com.application.Service.EntityRemoteService;

@Component
public class EntityRemoteServiceImplementation implements EntityRemoteService {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public OrderHotelModel getHotel(int hotelId) {
		String url = "http://localhost:20004/HavenHotel/Hotel/retrieve?hotelId="+hotelId;
		ResponseEntity<OrderHotelModel> exchange = restTemplate.exchange(url, HttpMethod.GET, null,OrderHotelModel.class);
		OrderHotelModel body = exchange.getBody();
		return body;
	}

	@Override
	public OrderUserModel getUser(int userId) {
		String url = "http://localhost:20001/HotelHaven/Login/Get?UserId="+userId;
		ResponseEntity<OrderUserModel> exchange = restTemplate.exchange(url,HttpMethod.GET, null, OrderUserModel.class);
		OrderUserModel body = exchange.getBody();
		return body;
	}

	@Override
	public OrderMenuModel getMenu(int dishId,int hotelId) {
		String url = "http://localhost:20003/HavenHotel/Menu/retrieve/ByDishIdAndByHotelId?dishId="+dishId+"&hotelId="+hotelId;
		ResponseEntity<OrderMenuModel> exchange = restTemplate.exchange(url, HttpMethod.GET, null,OrderMenuModel.class);
		OrderMenuModel body = exchange.getBody();
		return body;
	}
}
