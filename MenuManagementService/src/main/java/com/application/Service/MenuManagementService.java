package com.application.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.application.Entity.Menu;
import com.application.Model.MenuModel;

@Service
public interface MenuManagementService {
	
	Menu modifyMenu(MenuModel items) throws Exception;
	Menu createMenu(MenuModel items) throws Exception;
	Menu retrieveMenu(String dishName) throws Exception;
	Menu retrieveMenu(int disId) throws Exception;
	String removeMenu(int dishId) throws Exception;
	List<Menu> retrieveALLMenu(MenuModel hotelName);
	Menu retrieveMenu(int disId,int hotelId) throws Exception;
}
