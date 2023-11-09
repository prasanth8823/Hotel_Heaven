package com.application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.application.Entity.Menu;

import java.util.List;
import java.util.Optional;

@Component
public interface MenuManagementRepository extends JpaRepository<Menu, Integer> {
	
	Menu getByDishName(String dishName);
	
	Menu getByDishId(int disId);
	
	Menu getByDishIdAndHotelId(int dishId, int hotelId);

	Optional<Menu> findByDishName(String dishName);

	List<Menu> findAllByHotelName(String hotelName);

	
}
