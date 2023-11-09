package com.application.ServiceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.application.Entity.Menu;
import com.application.Model.HotelModel;
import com.application.Model.MenuModel;
import com.application.Repository.MenuManagementRepository;
import com.application.Service.MenuManagementService;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Component
public class MenuManagementServiceImplementation implements MenuManagementService {

	@Autowired
	MenuManagementRepository repo;

	@Autowired
	HotelManagementRemoteServiceImplementation imp;

	@Override
	public Menu modifyMenu(MenuModel items) throws Exception {
		Optional<Menu> findById = repo.findById(items.getDishId());

		if (findById.isPresent() == true) {
			Menu menu = findById.get();

			if (items.getDishName() != null) {
				menu.setDishName(items.getDishName());
			}
			if (items.getDishPrice() != 0) {
				menu.setDishPrice(items.getDishPrice());
			}
			return menu;
		} else {
			throw new EntityNotFoundException("dish Id not found :" + items.getDishId());
		}
	}

	@Override
	public Menu createMenu(MenuModel items) throws Exception {
		Optional<Menu> findByDishName = repo.findByDishName(items.getDishName());
		Menu menu = new Menu();
		if (findByDishName.isPresent() == true && menu.getHotelId() == items.getHotelId()) {
			throw new EntityExistsException("dish already exist :" + items.getDishName());
		} else {
			HotelModel hotelDetails = imp.getHotelDetails(items.getHotelId());
			menu.setHotelId(hotelDetails.getHotelId());
			menu.setHotelName(hotelDetails.getHotelName());
			menu.setDishName(items.getDishName());
			menu.setDishPrice(items.getDishPrice());
			Menu save = repo.save(menu);
			return save;
		}
	}

	@Override
	public Menu retrieveMenu(String dishName) throws Exception {
		Menu byDishName = repo.getByDishName(dishName);
		if (byDishName == null) {
			throw new EntityNotFoundException("dish not found");
		} else {
			return byDishName;
		}
	}

	@Override
	public Menu retrieveMenu(int disId) throws Exception {
		Menu byDishId = repo.getByDishId(disId);
		if (byDishId == null) {
			throw new EntityNotFoundException("dish not found");
		} else {
			return byDishId;
		}
	}

	@Override
	public String removeMenu(int hotelName) throws Exception {
		repo.deleteById(hotelName);
		return "deleted";
	}

	public List<Menu> retrieveALLMenu(MenuModel items) {
		List<Menu> findAll = repo.findAllByHotelName(items.getHotelName());
		return findAll;
	}

	@Override
	public Menu retrieveMenu(int disId, int hotelId) throws Exception {
		Menu byDishIdAndHotelId = repo.getByDishIdAndHotelId(disId, hotelId);
		if (byDishIdAndHotelId == null) {
			throw new EntityNotFoundException("dish not found");
		} else {
			return byDishIdAndHotelId;
		}
	}

}
