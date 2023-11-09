package com.application.Service;

import org.springframework.stereotype.Service;

import com.application.Model.OrderHotelModel;
import com.application.Model.OrderMenuModel;
import com.application.Model.OrderUserModel;

@Service
public interface EntityRemoteService {
	
	OrderHotelModel getHotel(int hotelId);
	OrderUserModel getUser(int userId);
	OrderMenuModel getMenu(int menuId,int hotelId);
}
