package com.application.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.application.Entity.Menu;
import com.application.Model.MenuModel;
import com.application.ServiceImplementation.MenuManagementServiceImplementation;


@RestController
public class MenuManagementController {

	@Autowired
	MenuManagementServiceImplementation imp;

	@PutMapping(value = "/HavenHotel/Menu/alter")
	private Menu putMenu(@RequestBody MenuModel items) throws Exception {
		Menu modifyedMenu = imp.modifyMenu(items);
		return modifyedMenu;
	}

	@PostMapping(value = "/HavenHotel/Menu/create")
	private Menu postMenu(@RequestBody MenuModel items) throws Exception {
		Menu createMenu = imp.createMenu(items);
		return createMenu;
	}

	@GetMapping(value = "/HavenHotel/Menu/retrieve/ByDishName")
	private Menu getMenu(@RequestParam String dishName) throws Exception {
		Menu retrieveMenu = imp.retrieveMenu(dishName);
		return retrieveMenu;
	}
	
	@GetMapping(value = "/HavenHotel/Menu/retrieve/ByDishId")
	private Menu getMenu(@RequestParam int dishId) throws Exception {
		Menu retrieveMenu = imp.retrieveMenu(dishId);
		return retrieveMenu;
	}
	
	@GetMapping(value = "/HavenHotel/Menu")
	private List<Menu> getAllMenu(@RequestBody MenuModel items) {
		List<Menu> allMenu = imp.retrieveALLMenu(items);
		return allMenu;
	}
	
	@DeleteMapping(value = "/HavenHotel/Menu/remove{dishId}")
	private String deleteMenu(@PathVariable int dishId) throws Exception {
		String removeMenu = imp.removeMenu(dishId);
		return removeMenu;
	}
	
	@GetMapping(value = "/HavenHotel/Menu/retrieve/ByDishIdAndByHotelId")
	private Menu getmenu(@RequestParam int dishId,int hotelId) throws Exception {
		Menu retrieveMenu = imp.retrieveMenu(dishId, hotelId);
		return retrieveMenu;
	}
}
